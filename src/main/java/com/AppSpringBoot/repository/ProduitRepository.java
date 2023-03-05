package com.AppSpringBoot.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.AppSpringBoot.entity.Produit;



public interface ProduitRepository extends PagingAndSortingRepository<Produit,Long> {
 public Produit findProduitById(Long id);

 Page<Produit> findByNomContains(String keyword, Pageable page);


}
