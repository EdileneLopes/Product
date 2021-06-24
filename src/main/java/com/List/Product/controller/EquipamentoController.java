package com.List.Product.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.List.Product.model.Equipamento;
import com.List.Product.service.EquipamentoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;




@Api("API REST ListProduct")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/equip")

public class EquipamentoController {

	@Autowired // é a ligação entre os objetos
	public EquipamentoService service;

	@PostMapping("/addEquipamento")
	@ApiOperation(value = "Salva um equipamento")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cria um Equipamento"),
			@ApiResponse(code = 400, message = "Falha nos dados enviados"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção."), })

	public ResponseEntity<Equipamento> post(@RequestBody @Valid Equipamento equipamento) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveEquipamento(equipamento));
	}

	@GetMapping
	@ApiOperation(value = "Retorna uma lista de Equipamentos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna uma lista de Equipamentos"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção."), })
	public ResponseEntity<List<Equipamento>> getAll() {
		return ResponseEntity.ok(service.getEquipamentos());

	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna um única equipamento")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna um única Equipamento"),
			@ApiResponse(code = 404, message = "Equipamento não localizado"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção."), })

	public Equipamento getById(@PathVariable Long id) {
		return service.getEquipamentoById(id);

	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta uma equipamento")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Equipamento excluido com sucesso."),
			@ApiResponse(code = 400, message = "Falha nos dados enviados"),
			@ApiResponse(code = 404, message = "Equipamento não localizado"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção."), })
	
	public Equipamento deleteById(@PathVariable Long id) {
		return service.deleteById(id);
	}

	
	
	@PutMapping
	@ApiOperation(value = "Altera uma equipamento")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Equipamento alterado com sucesso."),
			@ApiResponse(code = 400, message = "Falha nos dados enviados"),
			@ApiResponse(code = 404, message = "Equipamento não localizado"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção."), })

	public Equipamento put(@RequestBody Equipamento equipamento) {
		return service.updateEquipamento(equipamento);
	}

}
