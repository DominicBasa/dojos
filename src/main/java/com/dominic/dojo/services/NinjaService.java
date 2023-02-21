package com.dominic.dojo.services;

import com.dominic.dojo.models.Ninja;
import com.dominic.dojo.repositories.NinjaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NinjaService {

  @Autowired
  NinjaRepository ninjaRepository;

  public Ninja createNinja(Ninja ninja) {
    return ninjaRepository.save(ninja);
  }

  public List<Ninja> allNinja() {
    return ninjaRepository.findAll();
  }
}
