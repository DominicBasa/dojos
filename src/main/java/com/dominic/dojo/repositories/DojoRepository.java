package com.dominic.dojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dominic.dojo.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long> {
  List<Dojo> findAll();
}
