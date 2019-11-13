package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.ProduitRepository;
import com.example.demo.entities.Produit;

import java.util.List;

@Controller
public class ProduitController {
	@Autowired
	private ProduitRepository produitRepository;
	
	//@RequestMapping(value="/index", method = RequestMethod.GET)
	@GetMapping("/index")
	public String getAll(Model model,@RequestParam(name="page", defaultValue = "0") int page,
			@RequestParam(name="motCle", defaultValue = "") String mc) {
		Page<Produit> pageProduits=produitRepository.findByDesignationContains(mc, PageRequest.of(page, 4));
		model.addAttribute("listProduits",pageProduits.getContent());
		model.addAttribute("pages", new int[pageProduits.getTotalPages()]);
		model.addAttribute("currentPage", page);
		
		return "produits";
	}
	

	@GetMapping("/delete")
	public String delete(Long id) {
		produitRepository.deleteById(id);
		return "redirect:/index";
	}
	
}
