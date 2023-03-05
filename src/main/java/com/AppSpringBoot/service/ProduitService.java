package com.AppSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.AppSpringBoot.entity.Produit;
import com.AppSpringBoot.repository.ProduitRepository;

@Service
public class ProduitService {
	@Autowired
	private ProduitRepository produitrepository;
	public Page<Produit> listAll( int pageNumber){
		Pageable pageable=PageRequest.of(pageNumber-1, 5);
		return produitrepository.findAll(pageable);
		
	}

}
