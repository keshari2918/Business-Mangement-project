package com.business.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.business.entities.Product;
import com.business.repositories.ProductRepository;
@Component
public class ProductServices 
{
	@Autowired
	private ProductRepository productRepository;

	// Add a new product.
	public void addProduct(Product product)
	{
		this.productRepository.save(product);
	}


	// Get all products.
	public List<Product> getAllProducts()
	{
		List<Product> products = (List<Product>) this.productRepository.findAll();
		return products;
	}

	// Get a single product by id.
	public Product getProduct(int id)
	{
		Optional<Product> optional = this.productRepository.findById(id);
		Product product = optional.get();
		return product;
	}

	// Update an existing product.
	public void updateproduct(Product product, int id)
	{
		product.setPid(id);
		Optional<Product> optional = this.productRepository.findById(id);
		Product existingProduct = optional.get();

		if (existingProduct.getPid() == id)
		{
			this.productRepository.save(product);				
		}
	}
	// Delete a product.
	public void deleteProduct(int id)
	{
		this.productRepository.deleteById(id);
	}

	// Get a product by name.
	public Product getProductByName(String name)
	{
		
		Product product = this.productRepository.findByPname(name);
		if (product != null)
		{
			return product;
		}
		return null;
	
	}
}