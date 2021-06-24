package com.List.Product.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.List.Product.model.Sala;
import com.List.Product.repository.SalaRepository;

@Service
public class SalaService {

	@Autowired
	public SalaRepository repository;

	public Sala saveSala(Sala sala) {
		return repository.save(sala);
	}

	public List<Sala> getSalas() {
		return repository.findAll();
	}

	public Sala getSalaById(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Não encontrado " + id));
	}

		
	public Sala deleteById(Long id) {
		repository.deleteById(id);
		System.out.println("Sala apagado com sucesso.");
		return null;
	}

	public Sala updateSala(Sala sala) {
		Sala salaAlterado = repository.getOne(sala.getId());

		if (salaAlterado != null) {

			salaAlterado.setNome(sala.getNome());
			salaAlterado.setAndar(sala.getAndar());
			salaAlterado.setMetragem(sala.getMetragem());
			repository.save(salaAlterado);

		}
		return repository.save(salaAlterado);
	}

}



