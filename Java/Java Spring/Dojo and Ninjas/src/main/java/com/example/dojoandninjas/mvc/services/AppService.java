package com.example.dojoandninjas.mvc.services;

import com.example.dojoandninjas.mvc.models.Dojo;
import com.example.dojoandninjas.mvc.models.Ninja;
import com.example.dojoandninjas.mvc.repositories.DojoRepository;
import com.example.dojoandninjas.mvc.repositories.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService {
    private final DojoRepository dojoRepository;
    private final NinjaRepository ninjaRepository;
    public AppService(DojoRepository dojoRepository, NinjaRepository ninjaRepository) {
        this.dojoRepository = dojoRepository;
        this.ninjaRepository = ninjaRepository;
    }
    public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }
    public List<Ninja> allNinjas() {
        return (List<Ninja>) ninjaRepository.findAll();
    }
    public Ninja createNinja(Ninja b) {
        return ninjaRepository.save(b);
    }
    public Dojo createDojo(Dojo d) {
        return dojoRepository.save(d);
    }
    public Dojo findDojo(Long id) {
        return this.dojoRepository.findById(id).orElse(null);
    }



}
