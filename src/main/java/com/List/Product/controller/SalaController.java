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

import com.List.Product.model.Sala;
import com.List.Product.service.SalaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("API REST ListProduct")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/list")

public class SalaController {

	@Autowired // é a ligação entre os objetos
	public SalaService service;

	@PostMapping("/addSala")
	@ApiOperation(value = "Salva um sala")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cria uma Sala"),
			@ApiResponse(code = 400, message = "Falha nos dados enviados"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção."), })

	public ResponseEntity<Sala> post(@RequestBody @Valid Sala sala) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveSala(sala));
	}

	@GetMapping
	@ApiOperation(value = "Retorna uma lista de Salas")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna uma lista de Salas"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção."), })
	public ResponseEntity<List<Sala>> getAll() {
		return ResponseEntity.ok(service.getSalas());

	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna uma única sala")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna uma única Sala"),
			@ApiResponse(code = 404, message = "Sala não localizado"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção."), })

	public Sala getById(@PathVariable Long id) {
		return service.getSalaById(id);

	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta uma sala")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Sala excluida com sucesso."),
			@ApiResponse(code = 400, message = "Falha nos dados enviados"),
			@ApiResponse(code = 404, message = "Sala não localizado"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção."), })
	
	public Sala deleteById(@PathVariable Long id) {
		return service.deleteById(id);
	}

	
	@PutMapping
	@ApiOperation(value = "Altera uma sala")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Sala alterada com sucesso."),
			@ApiResponse(code = 400, message = "Falha nos dados enviados"),
			@ApiResponse(code = 404, message = "Sala não localizado"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção."), })

	public Sala put(@RequestBody Sala sala) {
		return service.updateSala(sala);
	}

}
