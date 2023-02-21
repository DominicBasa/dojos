package com.dominic.dojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.dominic.dojo.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {
  List<Ninja> findAll();
}
