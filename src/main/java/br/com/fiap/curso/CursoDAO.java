package br.com.fiap.curso;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CursoDAO extends CrudRepository<CursoEntity, Integer> {


}