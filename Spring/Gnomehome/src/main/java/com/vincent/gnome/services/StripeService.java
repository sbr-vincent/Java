package com.vincent.gnome.services;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.vincent.gnome.models.ChargeRequest;

@Service
public class StripeService {
	@Value("${STRIPE_SECRET_KEY}")
    private String secretKey;
	
	@Autowired
    public StripeService() {
        Stripe.apiKey = secretKey;
    }
	
    @PostConstruct
    public void init() {
        Stripe.apiKey = secretKey;
        System.out.println(secretKey);
        System.out.println("Banana");
    }
    public Charge charge(ChargeRequest chargeRequest) 
      throws StripeException {
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", chargeRequest.getAmount());
        chargeParams.put("currency", chargeRequest.getCurrency());
        chargeParams.put("description", chargeRequest.getDescription());
        chargeParams.put("source", chargeRequest.getStripeToken());
        return Charge.create(chargeParams);
    }
	public String getSecretKey() {
		return secretKey;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
}
