package com.example.dojoandninjas.mvc.repositories;

import com.example.dojoandninjas.mvc.models.Ninja;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NinjaRepository extends CrudRepository<Ninja,Long> {
}
