package com.aerztekasse.service;

import com.aerztekasse.model.Address;
import com.aerztekasse.model.OpeningHours;
import com.aerztekasse.model.Place;
import com.aerztekasse.model.Timing;
import com.aerztekasse.model.Place;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

//@RequiredArgsConstructor
@Service
public class PlaceService {

    final Logger log = LoggerFactory.getLogger(PlaceService.class);
    final List<Place> placeList = new ArrayList<>();

    public Place getPlaceAttributes(int id) {
        return placeList.stream().filter(x -> x.getId() == id).count() != 0
               ? placeList.stream().filter(x -> x.getId() == id).collect(Collectors.toList()).get(0) : null;
    }

    @PostConstruct
    /* Dumping dummy data for the application */
    public void dumpDummyData() throws ParseException {
        log.info("Inside PollService: dumpDummyData()");

        SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        /* Data for mockplace1 are same as mentioned as per example in the given assignment */
        Place place1 = new Place(1, "Le Cafe du Marche",
                new Address("Rue de Conthey", "17", "Sion", 1950, "", "CH"),
                new OpeningHours(Arrays.asList(
                        new Timing(isoFormat.parse("2021-03-16T11:30:00"), isoFormat.parse("2021-03-16T15:00:00")),
                        new Timing(isoFormat.parse("2021-03-16T18:30:00"), isoFormat.parse("2021-03-17T00:00:00")),
                        new Timing(isoFormat.parse("2021-03-17T11:30:00"), isoFormat.parse("2021-03-17T15:00:00")),
                        new Timing(isoFormat.parse("2021-03-17T18:30:00"), isoFormat.parse("2021-03-18T00:00:00")),
                        new Timing(isoFormat.parse("2021-03-18T11:30:00"), isoFormat.parse("2021-03-18T15:00:00")),
                        new Timing(isoFormat.parse("2021-03-18T18:30:00"), isoFormat.parse("2021-03-19T00:00:00")),
                        new Timing(isoFormat.parse("2021-03-19T11:30:00"), isoFormat.parse("2021-03-19T15:00:00")),
                        new Timing(isoFormat.parse("2021-03-19T18:30:00"), isoFormat.parse("2021-03-20T00:00:00")),
                        new Timing(isoFormat.parse("2021-03-20T18:00:00"), isoFormat.parse("2021-03-21T00:00:00")),
                        new Timing(isoFormat.parse("2021-03-21T11:30:00"), isoFormat.parse("2021-03-21T15:00:00"))
                )));

        Place place2 = new Place(2, "Priya Cafe",
                new Address("Bernstrasse", "51B", "Lucerne", 6003, "", "CH"),
                new OpeningHours(Arrays.asList(
                        new Timing(isoFormat.parse("2021-03-15T11:30:00"), isoFormat.parse("2021-03-15T15:00:00")),
                        new Timing(isoFormat.parse("2021-03-15T18:30:00"), isoFormat.parse("2021-03-16T00:00:00")),
                        new Timing(isoFormat.parse("2021-03-17T11:30:00"), isoFormat.parse("2021-03-17T15:00:00")),
                        new Timing(isoFormat.parse("2021-03-17T18:30:00"), isoFormat.parse("2021-03-18T00:00:00")),
                        new Timing(isoFormat.parse("2021-03-18T11:30:00"), isoFormat.parse("2021-03-18T15:00:00")),
                        new Timing(isoFormat.parse("2021-03-18T18:30:00"), isoFormat.parse("2021-03-19T00:00:00")),
                        new Timing(isoFormat.parse("2021-03-19T11:30:00"), isoFormat.parse("2021-03-19T15:00:00")),
                        new Timing(isoFormat.parse("2021-03-19T18:30:00"), isoFormat.parse("2021-03-20T00:00:00")),
                        new Timing(isoFormat.parse("2021-03-20T18:00:00"), isoFormat.parse("2021-03-21T00:00:00")),
                        new Timing(isoFormat.parse("2021-03-21T11:30:00"), isoFormat.parse("2021-03-21T15:00:00"))
                )));

        placeList.add(place1);
        placeList.add(place2);
    }
}
