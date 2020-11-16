package com.example.retrofit2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Planet implements Serializable {
    private Integer name;
    private String rotation_period;
    private String orbital_period;
    private String diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private String surface_water;
    private String population;

    private String planets;
    private List<String> films = new ArrayList<>();
    private List<String> residents = new ArrayList<>();

    private String created;
    private String edited;
    private String url;

    //Listas
    // API Planets dados da implementação.

}
   /*
            "name": "Tatooine",
            "rotation_period": "23",
            "orbital_period": "304",
            "diameter": "10465",
            "climate": "arid",
            "gravity": "1 standard",
            "terrain": "desert",
            "surface_water": "1",
            "population": "200000",
            "residents": [
            "http://swapi.dev/api/people/1/",
            "http://swapi.dev/api/people/2/",
            "http://swapi.dev/api/people/4/",
            "http://swapi.dev/api/people/6/",
            "http://swapi.dev/api/people/7/",
            "http://swapi.dev/api/people/8/",
            "http://swapi.dev/api/people/9/",
            "http://swapi.dev/api/people/11/",
            "http://swapi.dev/api/people/43/",
            "http://swapi.dev/api/people/62/"
            ],
            "films": [
            "http://swapi.dev/api/films/1/",
            "http://swapi.dev/api/films/3/",
            "http://swapi.dev/api/films/4/",
            "http://swapi.dev/api/films/5/",
            "http://swapi.dev/api/films/6/"
            ],
            "created": "2014-12-09T13:50:49.641000Z",
            "edited": "2014-12-20T20:58:18.411000Z",
            "url": "http://swapi.dev/api/planets/1/"


    */