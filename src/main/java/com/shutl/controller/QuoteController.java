package com.shutl.controller;

import com.shutl.model.Quote;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class QuoteController {

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/quote", method = POST)
    public @ResponseBody Quote quote(@RequestBody Quote quote) {
        Long rawPrice = Math.abs((Long.valueOf(quote.getDeliveryPostcode(), 36) - Long.valueOf(quote.getPickupPostcode(), 36))/100000000);

        String vehicle;
        if(quote.getVehicle() == null){
            vehicle = "no_vehicle";
        } else {
            vehicle = quote.getVehicle();
        }
        float markup;
        switch (vehicle) {
            case "bicycle":
                markup = (float) 1.1;
                break;
            case "motorbike":
                markup = (float) 1.15;
                break;
            case "parcel_car":
                markup = (float) 1.2;
                break;
            case "small_van":
                markup = (float) 1.3;
                break;
            case "large_van":
                markup = (float) 1.4;
                break;
            default:
                markup = 1;
                break;
        }
        Long price = Long.valueOf(Math.round(rawPrice*markup));

        return new Quote(quote.getPickupPostcode(), quote.getDeliveryPostcode(), vehicle , price);
    }
}
