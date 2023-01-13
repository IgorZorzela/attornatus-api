package com.attornatus.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.attornatus.api.model.Pessoa;
import com.attornatus.api.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	//create-update	
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);			
	}
	
	//read	
	public List<Pessoa> listar(){
		return pessoaRepository.findAll();
	}
	
	//show	
	public Optional<Pessoa> buscar(Long id) {
		return pessoaRepository.findById(id);
	}	
	
	//delete	
	public void deletar(Long id) {
		pessoaRepository.deleteById(id);
	}	

}
