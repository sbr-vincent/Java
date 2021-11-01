package com.vincent.gnome.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.vincent.gnome.models.Product;
import com.vincent.gnome.services.ProductService;
import com.vincent.gnome.services.UserService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productServ;
	
	@Autowired
	private UserService userServ;
	
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product, HttpSession session, Model model) {
		model.addAttribute("loggedInUser", userServ.getOne((Long) session.getAttribute("user_id")));
		
		return "newProduct";
	}
	
	@PostMapping("/products/create")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "newProduct";
		} else {
			productServ.createProduct(product);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/products/{productID}")
	public String viewProduct(@PathVariable("productID") Long id, HttpSession session, Model model) {
		model.addAttribute("loggedInUser", userServ.getOne((Long) session.getAttribute("user_id")));
		
		Product product = productServ.findProduct(id);
		model.addAttribute("oneProduct", product);
		
		return "viewProduct";
	}
	
	@GetMapping("/products/{productID}/edit")
	public String edit(@PathVariable("productID") Long id, Model model, HttpSession session) {
		if((Long) session.getAttribute("user_id") != 1) {
			return "redirect:/"; 
		}
		
		model.addAttribute("loggedInUser", userServ.getOne((Long) session.getAttribute("user_id")));
		Product product = productServ.findProduct(id);
		model.addAttribute("oneProduct", product);
		
		return "editProduct";
	}
	
	@PutMapping("/products/{productID}/update")
	public String update(@Valid @ModelAttribute("oneProduct") Product product, BindingResult result, @PathVariable("productID") Long id) {
		if(result.hasErrors()) {
			return "editProduct"; 
		} else {
			Product p = productServ.findProduct(id);
			p.setName(product.getName());
			p.setDescription(product.getDescription());
			p.setPrice(product.getPrice());
			p.setImage(product.getImage());
			
			productServ.createProduct(p);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/products/{productID}/delete")
	public String delete(@PathVariable("productID") Long id, HttpSession session) {
		if((Long) session.getAttribute("user_id") != 1) {
			return "redirect:/"; 
		}
		
		productServ.deleteProduct(id);
		
		return "redirect:/dashboard";
	}
	
	@GetMapping("/products/{productID}/addCart")
	public String addCart(@PathVariable("productID") Long id, HttpSession session) {
		if (session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
		
		Product product = productServ.findProduct(id);
		
		@SuppressWarnings("unchecked")
		ArrayList<Product> addedProducts = (ArrayList<Product>) session.getAttribute("cart");
		addedProducts.add(product);
		session.setAttribute("cart", addedProducts);
		
		return "redirect:/dashboard"; 
	}
}
