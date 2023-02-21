package com.dominic.dojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dominic.dojo.models.Dojo;
import com.dominic.dojo.repositories.DojoRepository;

@Service
public class DojoService {
  @Autowired DojoRepository dojoRepository;

  public void createDojo(Dojo dojo) {
    dojoRepository.save(dojo);
  }

  public List<Dojo> allDojos() {
    return dojoRepository.findAll();
  }

  public Dojo getDojo(Long id) {
    Optional<Dojo> optionalDojo = dojoRepository.findById(id);
    if(optionalDojo.isPresent()) {
      return optionalDojo.get();
    }else {
      return null;
    }
  }
}
