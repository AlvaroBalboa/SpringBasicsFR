package com.novauc.controllers;

import com.novauc.entities.Messages;
import com.novauc.entities.User;
import com.novauc.services.MessagesRepository;
import com.novauc.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by souporman on 3/13/17.
 */
@Controller
public class SpringBasicsFRController {

    @Autowired
    MessagesRepository messages;

    @Autowired
    UserRepository users;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        List<Messages> showingAll = (List) messages.findAll();

        model.addAttribute("name", session.getAttribute("userName"));

        model.addAttribute("messages",showingAll);
        return "home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String logout(Model model,HttpSession session, String userName){
        session.setAttribute("userName",userName);
        User user = new User(userName);
        users.save(user);
        model.addAttribute("name", session.getAttribute("userName"));
        return"redirect:/";
    }
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String loginUser(HttpSession session){
        session.invalidate();
        return"redirect:/";
    }

    @RequestMapping(value = "/create-message", method = RequestMethod.POST)
    public String createMessage(HttpSession session, String messageInput) {
        String username = (String ) session.getAttribute("userName");
        User poster = users.findFirstByName(username);
        if(poster!=null) {
            Messages currentMessage = new Messages(messageInput, poster);
            messages.save(currentMessage);
        }
        return "redirect:/";
    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteMessage(String messageID) {
        messages.delete(Integer.valueOf(messageID));

        //TODO I CANT BELIVE THIS ONE FREAKING LETTER MESSED WITH ME FOR ALMOST AN HOUR
        //messages.deleteFirstById(Integer.valueOf(messageId));

        //see this deletes all but not the specific one that i need it to delete
        //messages.deleteAll();
        return "redirect:/";
    }

}
