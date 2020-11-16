package com.example.retrofit2.bootstrap;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Passo 3 - Criar classe para mapear ENDPOINT e configurar classe para fazer o PARSER.
 * Converter JSON para objeto.
 **/

public class PlanetsAPI {

    //No retrofit você precisa colocar o  / (slash).
    //Prezado, por gentileza, informar fim de instrução (/) no endereço informado.
    public static final String ENDPOINT = "http://swapi.dev/api/planets/1/";

    public static Retrofit getClient() {
        return new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
