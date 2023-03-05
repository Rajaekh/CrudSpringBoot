package com.AppSpringBoot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.AppSpringBoot.entity.Produit;
import com.AppSpringBoot.repository.ProduitRepository;


@Controller
public class ProduitController {
	@Autowired
	private ProduitRepository produitrepository;

	@GetMapping("/index")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size,
			@RequestParam(name = "keyword", defaultValue = "") String keyword
) {
		
	
		
	
		Page<Produit> data= produitrepository.findByNomContains(keyword, PageRequest.of(page, size,Sort.by("prix").ascending()));
		model.addAttribute("data", data.getContent());
		model.addAttribute("totalitems", data.getNumberOfElements());
		model.addAttribute("pages", new int[data.getTotalPages()]);
		model.addAttribute("keyword",keyword);
		model.addAttribute("currentPage", page);
	
		return "produit";

	}

	@GetMapping("/findByid")
	@ResponseBody
	public Optional<Produit> findProById(Long id) {
		return produitrepository.findById(id);

	}

	@PostMapping("/add")
	public String save(Produit p) {
		produitrepository.save(p);

		return "redirect:/index";
	}

	@PostMapping("/update")

	public String updateProduit(Produit p) {
		Produit pexist = produitrepository.findById(p.getId()).get();
		if (pexist != null) {
			pexist.setNom(p.getNom());
			pexist.setPrix(p.getPrix());
			pexist.setDateproduction(p.getDateproduction());
			pexist.setDateexperation(p.getDateexperation());
			produitrepository.save(pexist);
		}
		return "redirect:/index";
	}
	@GetMapping("/deletep")
	public String delete(Long id,String keyword,int page ) {
		produitrepository.deleteById(id);
		
		return "redirect:/index?page="+page+"&keyword="+keyword;

	}
}
