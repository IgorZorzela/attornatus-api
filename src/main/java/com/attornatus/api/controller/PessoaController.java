package com.attornatus.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.attornatus.api.model.Pessoa;
import com.attornatus.api.repository.PessoaRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	//create-update
	@PostMapping("/pessoas")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Pessoa adcionar(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);			
	}
	
	//read
	@GetMapping("/pessoas")
	public List<Pessoa> listar(){
		return pessoaRepository.findAll();
	}
	
	//show
	@GetMapping("/pessoas/{id}")
	public Pessoa getPessoaById(@PathVariable Long id) {
		return pessoaRepository.findById(id).get();
	}	
	
	//delete
	@DeleteMapping("/pessoas/{id}")
	public void deletar(@PathVariable Long id) {
		pessoaRepository.deleteById(id);
	}	

}