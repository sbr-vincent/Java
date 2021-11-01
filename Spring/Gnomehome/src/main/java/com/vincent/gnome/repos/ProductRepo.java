package com.vincent.gnome.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vincent.gnome.models.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {
	ArrayList<Product> findAll();

}
