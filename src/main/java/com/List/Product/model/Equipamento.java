package com.List.Product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_equipamento")

public class Equipamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	private String marca;
	private String tipo;
	private String numeroSerie;
	private String descricao;
	private String numeroPatrimonio;  //ver se é inteiro
	private boolean ativo;
	
	
	@ManyToOne    //@OneToOne   1 equipamento por vez na hora criar a relação O equipamento
	@JoinColumn(name = "sala_id")
	private Sala sala;
	
	
	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}


	public Long getId() {
		return id;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNumeroPatrimonio() {
		return numeroPatrimonio;
	}
	public void setNumeroPatrimonio(String numeroPatrimonio) {
		this.numeroPatrimonio = numeroPatrimonio;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
	
	public Equipamento(String  marca, String tipo, String numeroSerie, String descricao, String numeroPatrimonio, boolean ativo) {
		this.marca = marca;
		this.tipo = tipo;
		this.numeroSerie = numeroSerie;
		this.descricao = descricao;
		this.numeroPatrimonio = numeroPatrimonio;
		this.ativo = ativo;

	}

	public Equipamento() {
	}
	

}
