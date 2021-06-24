package com.List.Product.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.List.Product.model.Equipamento;
import com.List.Product.repository.EquipamentoRepository;



@Service
public class EquipamentoService {


@Autowired
public EquipamentoRepository repository;

public Equipamento saveEquipamento(Equipamento equipamento) {
	return repository.save(equipamento);
}

public List<Equipamento> getEquipamentos() {
	return repository.findAll();
}

public Equipamento getEquipamentoById(Long id) {
	return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Não encontrado " + id));
}

	
public Equipamento deleteById(Long id) {
	repository.deleteById(id);
	System.out.println("Equipamento apagado com sucesso.");
	return null;
}


public Equipamento updateEquipamento(Equipamento equipamento) {
	Equipamento equipamentoAlterado = repository.getOne(equipamento.getId());

	if (equipamentoAlterado != null) {

		equipamentoAlterado.setMarca(equipamento.getMarca());
		equipamentoAlterado.setTipo(equipamento.getTipo());
		equipamentoAlterado.setNumeroSerie(equipamento.getNumeroSerie());
		equipamentoAlterado.setDescricao(equipamento.getDescricao());
		equipamentoAlterado.setNumeroPatrimonio(equipamento.getNumeroPatrimonio());
		equipamentoAlterado.setAtivo(equipamento.isAtivo());
		repository.save(equipamentoAlterado);

	}
	return repository.save(equipamentoAlterado);
}

}




