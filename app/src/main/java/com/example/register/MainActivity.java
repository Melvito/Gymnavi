package com.example.register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;


public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

        // Obtener referencias a las vistas
        EditText nombreEditText = findViewById(R.id.Edtnombre);
        EditText emailEditText = findViewById(R.id.Edtemail);
        EditText passwordEditText = findViewById(R.id.EdtContra);
        Button registerButton = findViewById(R.id.btnregistro);

        registerButton.setOnClickListener(view -> {
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            // Registrar al usuario en Firebase
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, task -> {
                        if (task.isSuccessful()) {
                            // El registro fue exitoso
                            // Puedes redirigir al usuario a la siguiente actividad o hacer lo que necesites
                            emailEditText.setText("");
                            passwordEditText.setText("");
                            Intent intent = new Intent(MainActivity.this, login.class);
                            startActivity(intent);
                            Toast.makeText(this, "Registro compleatado", Toast.LENGTH_SHORT).show();
                        } else {
                            // Hubo un error en el registro
                            Toast.makeText(this, "error fatal", Toast.LENGTH_SHORT).show();
                        }
         });
});
    }

    }
