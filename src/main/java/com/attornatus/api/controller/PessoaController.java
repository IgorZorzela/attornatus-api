package com.attornatus.api.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.attornatus.api.model.Pessoa;
import com.attornatus.api.repository.PessoaRepository;
import com.attornatus.api.service.PessoaService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	private Pessoa salvar(@RequestBody Pessoa pessoa) {
		return pessoaService.salvar(pessoa);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Pessoa> listaPessoa(){
		return pessoaService.listar();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Pessoa buscarPessoa(@PathVariable("id") Long id) {
		return pessoaService.buscar(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removePessoa(@PathVariable("id") Long id) {
		pessoaService.buscar(id)
				.map(pessoa -> {
					pessoaService.deletar(pessoa.getId());
					return Void.TYPE;
				}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualiza(@PathVariable("id") Long id,@RequestBody Pessoa pessoa) {
		
		pessoaService.buscar(id)
				.map(pessoaBase ->{
					modelMapper.map(pessoa, pessoaBase);
					pessoaService.salvar(pessoaBase);
					return Void.TYPE;
				}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
		
	}
	
	
	
}