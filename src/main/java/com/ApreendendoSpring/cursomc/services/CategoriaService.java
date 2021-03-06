package com.ApreendendoSpring.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ApreendendoSpring.cursomc.domain.Categoria;
import com.ApreendendoSpring.cursomc.repositories.CategoriaRepository;
import com.ApreendendoSpring.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);

		if (obj.orElse(null) == (null)) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado Id: " + id + ", Tipo: " + Categoria.class.getName());
		}

		return obj.orElse(null);
	}

}
