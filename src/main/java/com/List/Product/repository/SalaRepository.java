package com.List.Product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.List.Product.model.Sala;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long>{

}


