package com.example.register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class activity_exercise_detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Obtiene el nombre del ejercicio de la actividad anterior
        String exerciseName = getIntent().getStringExtra("exerciseName");
        // Configura el título de la actividad con el nombre del ejercicio
        setTitle(exerciseName);

        // Inicializa la vista del texto de detalles del ejercicio
        TextView textViewExerciseDetail = findViewById(R.id.textViewExerciseDetail);
        // Configura el texto con los detalles del ejercicio
        textViewExerciseDetail.setText("Detalles del ejercicio: " + exerciseName);

        // Inicializa la vista de la imagen del ejercicio
        ImageView imageViewExercise = findViewById(R.id.imageViewExercise);
        // Obtiene el recurso de imagen correspondiente al ejercicio
        int imageResourceId = getExerciseImageResource(exerciseName);
        // Configura la imagen del ejercicio
        imageViewExercise.setImageResource(imageResourceId);
    }

    // Método para obtener el recurso de imagen según el nombre del ejercicio
    private int getExerciseImageResource(String exerciseName) {
        // Lógica para obtener el recurso de imagen según el nombre del ejercicio
        if (exerciseName.equals("Press de banca")) {
            return R.drawable.presbanco;
        } else if (exerciseName.equals("Aperturas")) {
            return R.drawable.aper;
        } else if (exerciseName.equals("Fondos en paralelas")) {
            return R.drawable.fondos;
        } else if (exerciseName.equals("Dominadas")) {
            return R.drawable.dominadas;
        } else if (exerciseName.equals("Remo con barra")) {
            return R.drawable.remos;
        } else if (exerciseName.equals("Pull-ups")) {
            return R.drawable.pull;
        } else if (exerciseName.equals("Curl de Bíceps con Barra")) {
            return R.drawable.curlbarra;
        } else if (exerciseName.equals("Curl de Bíceps con Mancuernas")) {
            return R.drawable.curlman;
        } else if (exerciseName.equals("Curl de Martillo con Mancuernas")) {
            return R.drawable.martillo;
        } else if (exerciseName.equals("Fondos en Paralelas")) {
            return R.drawable.fondos;
        } else if (exerciseName.equals("Press de Tríceps con Barra")) {
            return R.drawable.presstri;
        } else if (exerciseName.equals("Lazo para Triceps")) {
            return R.drawable.extriceps;
        } else if (exerciseName.equals("Sentadillas")) {
            return R.drawable.senta;
        } else if (exerciseName.equals("Desplantes")) {
            return R.drawable.desplan;
        } else if (exerciseName.equals("Prensa de Piernas")) {
            return R.drawable.prensa;
        } else
            return R.drawable.default_image;// Imagen por defecto si no coincide ningún ejercicio
    }

    // Método para cerrar la actividad actual
    public void cerraractividad(View view) {
        finish();
    }
}