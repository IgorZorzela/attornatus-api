package com.attornatus.api.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String nome;		
	private Date dt_nasc;	
	private String endereco;	
	
}
/*
 * [
    "nome": "igor"
    "dt_nasc": "1977-03-15"
    "endereco": "rua"
    "cep": "86604634"
    "num_casa": "58"
    "cidade": "Rolandia"
]
 */
