package com.example.register;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.widget.TextView;

public class login extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

        EditText emailEditText = findViewById(R.id.correo);
        EditText passwordEditText = findViewById(R.id.contraseña);
        TextView registro = findViewById(R.id.Registro);
        Button loginButton = findViewById(R.id.iniciosesion);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, MainActivity.class);
                startActivity(intent);
                finish(); // Opcional, para cerrar la actividad de inicio de sesión si no se desea volver a ella
            }
        });

        loginButton.setOnClickListener(view -> {
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, task -> {
                        if (task.isSuccessful()) {
                            // Inicio de sesión exitoso, redirige a la siguiente actividad
                            // Inicio de sesión exitoso, redirige a la siguiente actividad después del inicio de sesión
                            Intent intent = new Intent(login.this, Pagina_principal.class);
                            startActivity(intent);
                            finish(); // Opcional, para cerrar la actividad de inicio de sesión si no se desea volver a ella

                            FirebaseUser user = mAuth.getCurrentUser();
                            if (user != null) {
                                // Aquí puedes obtener el ID de usuario, etc.
                                emailEditText.setText("");
                                passwordEditText.setText("");
                            }
                        } else {
                            // Fallo en el inicio de sesión, maneja los errores
                        }
                    });
   });
}

}
