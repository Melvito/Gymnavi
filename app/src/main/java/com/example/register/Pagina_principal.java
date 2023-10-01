package com.example.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Pagina_principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_principal);
    }

    // Método para abrir la actividad "ExeActivity" al hacer clic en un botón
    public void openejercicios(View view) {
        Intent intent = new Intent(this, activity_exe.class); // Crea un Intent para la actividad ExeActivity
        startActivity(intent); // Inicia la actividad ExeActivity
    }

    // Método para abrir la actividad "ObjeActivity" al hacer clic en un botón
    public void abrirobje(View view) {
        Intent intent = new Intent(this, activity_obje.class); // Crea un Intent para la actividad ObjeActivity
        startActivity(intent); // Inicia la actividad ObjeActivity
    }

    // Método para abrir la actividad "ObjeActivity" al hacer clic en un botón
    public void abriperfil(View view) {
        Intent intent = new Intent(this, activity_perfil.class); // Crea un Intent para la actividad ObjeActivity
        startActivity(intent); // Inicia la actividad PerfilActivity
    }
}