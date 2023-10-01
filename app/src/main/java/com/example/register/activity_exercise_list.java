package com.example.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class activity_exercise_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);
        // Inicializa las vistas (UI elements) desde el diseño XML
        TextView tvGroupTitle = findViewById(R.id.tvGroupTitle);
        ListView listViewExercises = findViewById(R.id.listViewExercises);

        // Obtiene el nombre del grupo muscular de la actividad anterior
        String groupName = getIntent().getStringExtra("groupName");
        // Configura el título del grupo muscular en la vista
        tvGroupTitle.setText("Ejercicios para: " + groupName);

        // Obtiene la lista de ejercicios para el grupo muscular
        ArrayList<String> exercises = getExercisesForGroup(groupName);

        // Crea un ArrayAdapter para la lista de ejercicios
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, exercises);
        listViewExercises.setAdapter(adapter);

        // Configura el clic en elementos de la lista
        listViewExercises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedExercise = exercises.get(position);
                openExerciseDetail(selectedExercise); // Abre una nueva actividad
            }
        });
    }

    // Método para abrir otra actividad (MainActivity)
    public void openOtherActivity(View view) {
        Intent intent = new Intent(this, activity_exe.class);
        startActivity(intent);
        finish();
    }

    // Método para obtener la lista de ejercicios según el grupo muscular
    private ArrayList<String> getExercisesForGroup(String groupName) {

        ArrayList<String> exercises = new ArrayList<>();
// Lógica para agregar ejercicios según el grupo muscular
        if (groupName.equals("Pecho")) {
            exercises.add("Press de banca");
            exercises.add("Aperturas");
            exercises.add("Fondos en paralelas");
        } else if (groupName.equals("Espalda")) {
            exercises.add("Dominadas");
            exercises.add("Remo con barra");
            exercises.add("Pull-ups");
        } else if (groupName.equals("Biceps")) {
            exercises.add("Curl de Bíceps con Barra");
            exercises.add("Curl de Bíceps con Mancuernas");
            exercises.add("Curl de Martillo con Mancuernas");
        } else if (groupName.equals("Triceps")) {
            exercises.add("Fondos en Paralelas");
            exercises.add("Press de Tríceps con Barra");
            exercises.add("Lazo para Triceps");
        } else if (groupName.equals("Pierna")) {
            exercises.add("Sentadillas");
            exercises.add("Desplantes");
            exercises.add("Prensa de Piernas");
        }


        return exercises;
    }

    // Método para abrir la actividad ExerciseDetailActivity con el nombre del ejercicio
    private void openExerciseDetail(String exerciseName) {
        Intent intent = new Intent(this, activity_exercise_detail.class);
        intent.putExtra("exerciseName", exerciseName);
        startActivity(intent);
    }
}