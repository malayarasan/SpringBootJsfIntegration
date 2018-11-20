package com.auth0.samples.bootfaces;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "session")
@Component(value = "productEditController")
@ELBeanName(value = "productEditController")
@Join(path = "/productEdit", to = "/product-edit.jsf")
public class ProductEditController {
	@Autowired
	private ProductRepository productRepository;
	private Product product = new Product();
	public String save() {
		productRepository.save(product);
		product = new Product();
		return "/product-list.xhtml?faces-redirect=true";
	}

	public String delete() {
		productRepository.delete(product);
		product = new Product();
		return "/product-list.xhtml?faces-redirect=true";
	}
	public Product getProduct() {
		return product;
	}
}
