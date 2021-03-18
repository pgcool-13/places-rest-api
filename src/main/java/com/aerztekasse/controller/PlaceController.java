package com.aerztekasse.controller;

import com.aerztekasse.exception.PlaceNotFoundException;
import com.aerztekasse.model.Place;
import com.aerztekasse.service.PlaceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@CrossOrigin
@AllArgsConstructor
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping("/api/place/id/{id}")
    public Place getPlaceAttributes(@PathVariable("id") int id) throws IOException {
        Place place = placeService.getPlaceAttributes(id);

        if (place == null)
            throw new PlaceNotFoundException();

        return place;
    }
}
