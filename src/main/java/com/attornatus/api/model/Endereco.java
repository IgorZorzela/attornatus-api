package com.attornatus.api.model;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "endereco")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="endereco_id")
	private Long id;
	
	private String logradouro;
	private int cep;	
	private int num_casa;	
	private String cidade;
	private Boolean endereco_principal;
	@OneToOne(mappedBy = "endereco")	
    private Pessoa pessoa;	
	
	public Endereco() {}

}
