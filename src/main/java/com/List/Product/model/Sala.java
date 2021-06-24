package com.List.Product.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_sala")

public class Sala {

	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY) 
		private Long id;
		
		private int andar;
		private String nome;
		private Double metragem;
		
		/*
		@OneToMany
		List<Equipamento> equipamento;
		*/
				
		public Long getId() {
			return id;
		}

		public int getAndar() {
			return andar;
		}

		public void setAndar(int andar) {
			this.andar = andar;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public Double getMetragem() {
			return metragem;
		}

		public void setMetragem(Double metragem) {
			this.metragem = metragem;
		}

		
		public Sala(int andar, String nome, Double metragem) {
			this.andar = andar;
			this.nome = nome;
			this.metragem = metragem;

		}

		public Sala() {
		}
		
		

		
	}

