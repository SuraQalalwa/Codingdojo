package com.example.dojoandninjas.mvc.repositories;

import com.example.dojoandninjas.mvc.models.Dojo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long> {
    List<Dojo> findAll();
    @Override
    Optional<Dojo> findById(Long id);

}
