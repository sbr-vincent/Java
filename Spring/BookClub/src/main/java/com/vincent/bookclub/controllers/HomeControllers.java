package com.vincent.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vincent.bookclub.models.LoginUser;
import com.vincent.bookclub.models.User;
import com.vincent.bookclub.services.BookService;
import com.vincent.bookclub.services.UserServices;

@Controller
public class HomeControllers {
	@Autowired
    private UserServices userServ;
	
	@Autowired
	private BookService bookService;
    
    @GetMapping("/")
    public String index(Model model, HttpSession session) {
    	if (session.getAttribute("user_id") != null) {
    		return "redirect:/books";
    	}
    	
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        userServ.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/books";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        User user = userServ.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        session.setAttribute("user_id", user.getId());
        return "redirect:/books";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.removeAttribute("user_id");
    	
    	return "redirect:/";
    }
    
    @GetMapping("/books")
    public String home(Model model, HttpSession session) {
    	if (session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	model.addAttribute("loggedInUser", userServ.getOne((Long) session.getAttribute("user_id")));
    	model.addAttribute("allBooks", bookService.allBooks());
        return "books.jsp";
    }
    
    
}
