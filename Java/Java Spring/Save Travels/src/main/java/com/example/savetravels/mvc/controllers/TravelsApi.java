package com.example.savetravels.mvc.controllers;

import com.example.savetravels.mvc.models.Travel;
import com.example.savetravels.mvc.services.TravelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//return text only to check frontend //it will not render or return pages only for testing Api's في حال ما بدي اعمل فرونت اند لافحص الشغل
public class TravelsApi {
    private final TravelService travelService;
    public TravelsApi(TravelService travelService){ // injecting denpdancy
        this.travelService = travelService;
    }
    @RequestMapping("/api/travels")
    public List<Travel> index() {
        return travelService.allTravels();
    }

    @RequestMapping(value="/api/travels", method= RequestMethod.POST)
    public Travel create(@RequestParam(value="expense") String expense,
                       @RequestParam(value="vendor") String vendor,
                       @RequestParam(value="amount") double amount) {
        Travel travel = new Travel(expense, vendor,amount);
        return travelService.createTravel(travel);
    }

    @RequestMapping("/api/books/{id}")
    public Travel show(@PathVariable("id") Long id) {
        Travel travel = travelService.findTravel(id);
        return travel;
    }

    ////other methods removed for brevity
    @RequestMapping(value="/api/travels/{id}", method=RequestMethod.PUT)
    public Travel update(@PathVariable("id") Long id,
                         @RequestParam(value="expense") String expense,
                         @RequestParam(value="vendor") String vendor,
                         @RequestParam(value="amount") double amount) {
        Travel travel = travelService.updateTravel(id, expense, vendor, amount);
        return travel;
    }

    @RequestMapping(value="/api/travels/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        travelService.deleteTravel(id);
    }
}
