package com.example.register;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class activity_perfil extends AppCompatActivity {
    private ImageView profileImageView;
    private Button selectImageButton;
    private EditText nameEditText;
    private EditText emailEditText;
    private Button saveButton;
    private Button backButton;
    private static final int PICK_IMAGE_REQUEST = 1;
    private static final int EDIT_PROFILE_REQUEST = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        profileImageView = findViewById(R.id.profile_image_view);
        selectImageButton = findViewById(R.id.select_image_button);
        nameEditText = findViewById(R.id.name_edit_text);
        emailEditText = findViewById(R.id.email_edit_text);
        saveButton = findViewById(R.id.save_button);
        backButton = findViewById(R.id.back_button);

        selectImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveProfileChanges();
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void openGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    private void saveProfileChanges() {
        String newName = nameEditText.getText().toString();
        String newEmail = emailEditText.getText().toString();

        // You can save the newName and newEmail in your preferred storage (e.g., SharedPreferences).

        // For now, let's just update the UI.
        nameEditText.setText(newName);
        emailEditText.setText(newEmail);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri imageUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                profileImageView.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (requestCode == EDIT_PROFILE_REQUEST && resultCode == RESULT_OK && data != null) {
            // Update the profile information based on the edited data
            String newName = data.getStringExtra("newName");
            String newEmail = data.getStringExtra("newEmail");

            nameEditText.setText(newName);
            emailEditText.setText(newEmail);
        }
    }

    private void openEditProfileActivity() {
        Intent intent = new Intent(this, activity_perfil.class);
        startActivityForResult(intent, EDIT_PROFILE_REQUEST);
    }

    public void vuelves(View view) {
        finish(); // Cierra la actividad actual y vuelve a la actividad anterior
    }
}