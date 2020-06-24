package com.udacity.pricing.api;

import com.udacity.pricing.domain.price.Price;
import com.udacity.pricing.service.PriceException;
import com.udacity.pricing.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Implements a REST-based controller for the pricing service.
 */
@RestController
@RequestMapping("/services/prices")
public class PricingController {

    private final PriceService priceService;

    @Autowired
    public PricingController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    public ResponseEntity<List<Price>> getPrices() {
        List<Price> list = priceService.getPrices();
        return new ResponseEntity<List<Price>>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Price> getPriceById(@PathVariable long id) throws PriceException {
        Price price = priceService.getPriceById(id);
        return new ResponseEntity<Price>(price, HttpStatus.OK);
    }
//    /**
//     * Gets the price for a requested vehicle.
//     * @param vehicleId ID number of the vehicle for which the price is requested
//     * @return price of the vehicle, or error that it was not found.
//     */
//    @GetMapping
//    public Price get(@RequestParam Long vehicleId) {
//        try {
//            return PriceService.getPrice(vehicleId);
//        } catch (PriceException ex) {
//            throw new ResponseStatusException(
//                    HttpStatus.NOT_FOUND, "Price Not Found", ex);
//        }
//
//    }
}
