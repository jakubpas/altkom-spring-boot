package hello.service;

import org.springframework.beans.factory.annotation.Autowired;

import hello.repo.ProductRepo;

public class ProductService {
	@Autowired
	private ProductRepo repo;
}
