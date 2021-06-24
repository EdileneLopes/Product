package com.List.Product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.List.Product.model.Equipamento;




@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamento, Long>{

}