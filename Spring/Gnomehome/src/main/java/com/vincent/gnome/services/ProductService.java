package com.vincent.gnome.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vincent.gnome.models.Product;
import com.vincent.gnome.repos.ProductRepo;

@Service
public class ProductService {
	private final ProductRepo productRepo;
	
	public ProductService(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}
	
	public ArrayList<Product> allProducts() {
		return productRepo.findAll();
	}
	
	public Product createProduct(Product p) {
		return productRepo.save(p);
	}
	
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}
	
	public void deleteProduct(Long id) {
		productRepo.deleteById(id);
	}
	
}
