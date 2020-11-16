package com.example.retrofit2.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.retrofit2.R;
import com.example.retrofit2.adapter.PlanetsAdapter;
import com.example.retrofit2.bootstrap.PlanetsAPI;
import com.example.retrofit2.model.DefaultModel;
import com.example.retrofit2.model.Planet;
import com.example.retrofit2.resource.PlanetsResource;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PlanetsActivity extends AppCompatActivity {

    ListView listViewPlanetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planets);
    }

    public void listarPlanets(View view) {

        Retrofit retrofit = PlanetsAPI.getClient();

        PlanetsResource planetsResource = retrofit.create(PlanetsResource.class);

        final Call<DefaultModel> lista = planetsResource.get();

        try {
            lista.enqueue(new Callback<DefaultModel>() {
                @Override
                public void onResponse(Call<DefaultModel> call, Response<DefaultModel> response) {
                    try {
                        DefaultModel resposta = response.body();

                        List<Planet> planetas = resposta.getResults();

                        PlanetsAdapter planeta = new PlanetsAdapter(getApplicationContext(), planetas);

                        listViewPlanetas = findViewById(R.id.listViewPlanets);
                        listViewPlanetas.setAdapter(planeta);


                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Ocorreu um erro " +
                                        "no processamento.\n\n" + e.getMessage(),
                                Toast.LENGTH_LONG).show();
                        Log.e("lista -- Erro", "\n\n" + e.getMessage() + "\n" +
                                "\n");
                    }
                }

                @Override
                public void onFailure(Call<DefaultModel> call, Throwable t) {
                    //Método responsável pelos erros.
                    Toast.makeText(getApplicationContext(), "Ocorreu um erro " +
                            "no serviço.\n" + t.getMessage(), Toast.LENGTH_LONG).show();
                    Log.e("app-planets", "\n\n" + t.getMessage() + "\n\n");//Método responsável pelos erros.
                    Toast.makeText(getApplicationContext(), "Ocorreu um erro " +
                            "no serviço.\n" + t.getMessage(), Toast.LENGTH_LONG).show();
                    Log.e("app-planets", "\n\n" + t.getMessage() + "\n\n");
                }
            });
        } catch (Exception e) {
            Log.i("ERRO", "Erro na busca" + e.getMessage());
        }

    }
}
