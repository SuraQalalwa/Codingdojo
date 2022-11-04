package com.example.savetravels.mvc.repositories;

import com.example.savetravels.mvc.models.Travel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TravelRepository extends CrudRepository<Travel, Long> {//<class type, type of id in this class>
    List<Travel> findAll();
    List<Travel> findByExpenseContaining(String search);
    Long countByVendorContaining(String search);
    Long deleteByExpenseStartingWith(String search);// برجع الاي دي للاشي المحذوف (القصد بlong)



}
