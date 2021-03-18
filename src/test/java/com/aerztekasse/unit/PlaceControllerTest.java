package com.aerztekasse.unit;

import com.aerztekasse.controller.PlaceController;
import com.aerztekasse.model.Address;
import com.aerztekasse.model.OpeningHours;
import com.aerztekasse.model.Place;
import com.aerztekasse.model.Timing;
import com.aerztekasse.service.PlaceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

@RunWith(SpringRunner.class)
@WebMvcTest(PlaceController.class)
public class PlaceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlaceService placeService;

    @Test
    public void getPlaceByIdTest() throws Exception {

        SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        List<Timing> timingList = Arrays.asList(
                new Timing(isoFormat.parse("2021-03-16T11:30:00"), isoFormat.parse("2021-03-16T15:00:00")),
                new Timing(isoFormat.parse("2021-03-16T18:30:00"), isoFormat.parse("2021-03-17T00:00:00")),
                new Timing(isoFormat.parse("2021-03-17T11:30:00"), isoFormat.parse("2021-03-17T15:00:00")),
                new Timing(isoFormat.parse("2021-03-17T18:30:00"), isoFormat.parse("2021-03-18T00:00:00")),
                new Timing(isoFormat.parse("2021-03-18T11:30:00"), isoFormat.parse("2021-03-18T15:00:00")),
                new Timing(isoFormat.parse("2021-03-18T18:30:00"), isoFormat.parse("2021-03-19T00:00:00")),
                new Timing(isoFormat.parse("2021-03-19T11:30:00"), isoFormat.parse("2021-03-19T15:00:00")),
                new Timing(isoFormat.parse("2021-03-19T18:30:00"), isoFormat.parse("2021-03-20T00:00:00")),
                new Timing(isoFormat.parse("2021-03-20T18:00:00"), isoFormat.parse("2021-03-21T00:00:00")),
                new Timing(isoFormat.parse("2021-03-21T11:30:00"), isoFormat.parse("2021-03-21T15:00:00")));

        Place mockplace = new Place(1, "Le Cafe du Marche",
                new Address("Rue de Conthey", "17", "Sion", 1950, "", "CH"),
                new OpeningHours(timingList));

        Mockito.when(
                placeService.getPlaceAttributes(Mockito.anyInt())
        ).thenReturn(mockplace);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/api/place/id/1").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{id:1,name:\"Le Cafe du Marche\",address:{streetName:\"Rue de Conthey\",streetNo:\"17\",city:\"Sion\",zipCode:1950,state:\"\",country:\"CH\"}," +
                "openingHours:{timing:[{startsAt:\"2021-03-16T11:30:00.000+00:00\",endsAt:\"2021-03-16T15:00:00.000+00:00\"}," +
                "{startsAt:\"2021-03-16T18:30:00.000+00:00\",endsAt:\"2021-03-17T00:00:00.000+00:00\"}," +
                "{startsAt:\"2021-03-17T11:30:00.000+00:00\",endsAt:\"2021-03-17T15:00:00.000+00:00\"}," +
                "{startsAt:\"2021-03-17T18:30:00.000+00:00\",endsAt:\"2021-03-18T00:00:00.000+00:00\"}," +
                "{startsAt:\"2021-03-18T11:30:00.000+00:00\",endsAt:\"2021-03-18T15:00:00.000+00:00\"}," +
                "{startsAt:\"2021-03-18T18:30:00.000+00:00\",endsAt:\"2021-03-19T00:00:00.000+00:00\"}," +
                "{startsAt:\"2021-03-19T11:30:00.000+00:00\",endsAt:\"2021-03-19T15:00:00.000+00:00\"}," +
                "{startsAt:\"2021-03-19T18:30:00.000+00:00\",endsAt:\"2021-03-20T00:00:00.000+00:00\"}," +
                "{startsAt:\"2021-03-20T18:00:00.000+00:00\",endsAt:\"2021-03-21T00:00:00.000+00:00\"}," +
                "{startsAt:\"2021-03-21T11:30:00.000+00:00\",endsAt:\"2021-03-21T15:00:00.000+00:00\"}" +
                "]}}";

        String expectedFalse = "{'id':1,'name':'Priya Cafe'}";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);

        JSONAssert.assertNotEquals(expectedFalse, result.getResponse()
                .getContentAsString(), false);
    }

}
