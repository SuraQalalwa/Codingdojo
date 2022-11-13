package com.example.savetravels.mvc.services;

import com.example.savetravels.mvc.models.Travel;
import com.example.savetravels.mvc.repositories.TravelRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class TravelService {
    private final TravelRepository travelRepository; //related to dependency injection

    public TravelService(TravelRepository travelRepository) { //here we inject the service dependency in repository dependency
        this.travelRepository = travelRepository;
    }
    public List<Travel> allTravels() {
        return travelRepository.findAll();
    }
    public Travel createTravel(Travel b) {
        return travelRepository.save(b);
    }
    public Travel findTravel(Long id) {
        Optional<Travel> optionalTravel = travelRepository.findById(id); // optional since it may not find nothing and to do not have error
        if(optionalTravel.isPresent()) {
            return optionalTravel.get();
        } else {
            return null;
        }
    }

    public Travel updateTravel(Long id, String expense, String vendor, double amount) {
        Optional<Travel> travel1 = travelRepository.findById(id);
        if(travel1.isPresent()) {
            Travel updateTravel= travel1.get();
            updateTravel.setExpense(expense);
            updateTravel.setVendor(vendor);
            updateTravel.setAmount(amount);

            return travelRepository.save(updateTravel);
        }
        else {
            return null;
        }
    }
    public void deleteTravel(Long id) {
        travelRepository.deleteById(id);
    }

    public Travel updateTravel(Travel travel) {
        return travelRepository.save((travel));
    }
}
// find all
// find by id
// create
//update all by default in all services
//delete
