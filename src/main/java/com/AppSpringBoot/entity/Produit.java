package com.AppSpringBoot.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Produit {
@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Produit() {
		super();
	}

	public Produit(String nom, Float prix, Date dateproduction, Date dateexperation) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.dateproduction = dateproduction;
		this.dateexperation = dateexperation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Float getPrix() {
		return prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}

	public Date getDateproduction() {
		return dateproduction;
	}

	public void setDateproduction(Date dateproduction) {
		this.dateproduction = dateproduction;
	}

	public Date getDateexperation() {
		return dateexperation;
	}

	public void setDateexperation(Date dateexperation) {
		this.dateexperation = dateexperation;
	}

	private String nom;
	private Float prix;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateproduction;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateexperation;
}
