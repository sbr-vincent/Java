package com.vincent.gnome.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.commons.math3.util.Precision;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vincent.gnome.models.ChargeRequest;
import com.vincent.gnome.models.Product;


@Controller
public class CheckoutController {
	
    @Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;
    
    @SuppressWarnings("unchecked")
    @RequestMapping("/checkout")
    public String checkout(Model model, HttpSession session) {
    	
    	ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("cart");
    	
    	int total = 0;
    	int tax = 2;
    	int orderTotal = 0;
  	
    	if (products != null) {
    		for (Product product : products) {
    			total += product.getPrice();
    		}    
    		orderTotal = Math.round(total + tax);
    	}

    	System.out.println(orderTotal);
    	model.addAttribute("amount", orderTotal * 100);
    	model.addAttribute("stripePublicKey", stripePublicKey);
    	model.addAttribute("currency", ChargeRequest.Currency.USD);
    	return "checkout";
    }

	public String getStripePublicKey() {
		return stripePublicKey;
	}

	public void setStripePublicKey(String stripePublicKey) {
		this.stripePublicKey = stripePublicKey;
	}
}
