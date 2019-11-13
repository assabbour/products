package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.dao.ProduitRepository;
import com.example.demo.entities.Produit;

@SpringBootApplication
@ComponentScan("com.example.demo.entities")
@ComponentScan("com.example.demo.web")
@ComponentScan("com.example.demo.dao")
@ComponentScan("com.example.demo.security")
public class CrudProduitsApplication implements CommandLineRunner{
	
	@Autowired
	private ProduitRepository produitRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(CrudProduitsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*produitRepository.save(new Produit(null, "pc", 97, 5));
		produitRepository.save(new Produit(null, "tel", 7, 3));
		produitRepository.save(new Produit(null, "impriment", 9, 2));
		produitRepository.save(new Produit(null, "apareil", 3, 1));
		*/
		produitRepository.findAll().forEach(p ->{
			System.out.println(p.getDesignation());
		});
		
	}
	
	
	
	
	

}
