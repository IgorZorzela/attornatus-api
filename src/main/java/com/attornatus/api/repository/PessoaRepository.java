package com.attornatus.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attornatus.api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
