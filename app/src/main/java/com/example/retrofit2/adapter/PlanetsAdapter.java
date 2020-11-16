package com.example.retrofit2.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import com.example.retrofit2.R;

import com.example.retrofit2.model.Planet;

public class PlanetsAdapter extends BaseAdapter {

    private final Context context;
    private final List<Planet> planets;

    public PlanetsAdapter(Context context, List<Planet> planets) {
        this.context = context;
        this.planets = planets;
    }

    @Override
    public int getCount() {
        return this.planets != null ? this.planets.size() : 0;
    }

    @Override
    public Planet getItem(int i) {
        return this.planets.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup) {
        //Primeira coisa que precisamos verificar é se o layout está instanciado
        //senão, leio a referência do xml para objeto java.
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_planets,
                    viewGroup, false);
        }

        //Procura o item dentro da lista para ser 'exibido' na listView
        Planet planets = getItem(posicao);

        //Criar a referência de atributos/objeto java para ser customizar uma listView
        TextView txtPlanetName, txtRotationPeriod, txtOrbitalPeriod, txtDiameter,
                txtClimate, txtGravity, txtTerrain, txtSurfaceWater, txtPopulation;

        try {
            txtPlanetName = view.findViewById(R.id.txtPlanetName);
            txtRotationPeriod = view.findViewById(R.id.txtRotationPeriod);
            txtOrbitalPeriod = view.findViewById(R.id.txtOrbitalPeriod);
            txtDiameter = view.findViewById(R.id.txtDiameter);
            txtClimate = view.findViewById(R.id.txtClimate);
            txtGravity = view.findViewById(R.id.txtGravity);
            txtTerrain = view.findViewById(R.id.txtTerrain);
            txtSurfaceWater = view.findViewById(R.id.txtSurfaceWater);
            txtPopulation = view.findViewById(R.id.txtPopulation);

            txtPlanetName.setText(planets.getName());
            txtRotationPeriod.setText(planets.getRotation_period());
            txtOrbitalPeriod.setText(planets.getOrbital_period());
            txtDiameter.setText(planets.getDiameter());
            txtClimate.setText(planets.getClimate());
            txtGravity.setText(planets.getGravity());
            txtTerrain.setText(planets.getTerrain());
            txtSurfaceWater.setText(planets.getSurface_water());
            txtPopulation.setText(planets.getPopulation());

        } catch (Exception e) {
            Log.e("ERRO!", "Erro ao extrair" + e.getMessage());
        }
        return view;
    }
}
