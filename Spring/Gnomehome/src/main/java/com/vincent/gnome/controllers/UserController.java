package com.vincent.gnome.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.math3.util.Precision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.vincent.gnome.models.LoginUser;
import com.vincent.gnome.models.Product;
import com.vincent.gnome.models.User;
import com.vincent.gnome.services.ProductService;
import com.vincent.gnome.services.UserService;

@Controller
public class UserController {
	@Autowired
    private UserService userServ;
	
	@Autowired
    private ProductService productServ;
	
	@GetMapping("/")
    public String index(Model model, HttpSession session) {
    	if (session.getAttribute("user_id") != null) {
    		return "redirect:/dashboard";
    	}
    	
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        userServ.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index";
        }
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/dashboard";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        User user = userServ.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index";
        }
        session.setAttribute("user_id", user.getId());
        return "redirect:/dashboard";
    }
    
    @SuppressWarnings("unchecked")
	@GetMapping("/cart")
    public String cart(Model model, HttpSession session) {
    	if (session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("cart");
    	
    	Double total = 0.0;
    	Double tax = 2.0;
    	Double orderTotal = 0.0;
    	model.addAttribute("loggedInUser", userServ.getOne((Long) session.getAttribute("user_id")));
    	model.addAttribute("cart", products);
  	
    	if (products != null) {
    		for (Product product : products) {
    			total += Precision.round(product.getPrice(),2);
    		}    
    		orderTotal = Precision.round( tax + total,2);
    	}
    	
    	model.addAttribute("total", total);
    	model.addAttribute("tax", tax);
    	model.addAttribute("orderTotal", orderTotal);

        return "cart";
    }
    
    @GetMapping("/delete/cartItem/{productIdx}")
    public String removeItem(@PathVariable("productIdx") int idx, HttpSession session) {
    	@SuppressWarnings("unchecked")
		ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("cart");
    	products.remove(idx);
    	
    	return "redirect:/cart";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.removeAttribute("user_id");
    	session.setAttribute("cart", null);
    	
    	return "redirect:/";
    }
    
    @GetMapping("/dashboard")
    public String home(Model model, HttpSession session) {
    	if (session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	
    	if (session.getAttribute("cart") == null) {
    		session.setAttribute("cart", new ArrayList<Product>());
    	}
    	
    	
    	model.addAttribute("loggedInUser", userServ.getOne((Long) session.getAttribute("user_id")));
    	model.addAttribute("allProducts", productServ.allProducts());
        return "dashboard";
    }
}
