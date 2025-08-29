package com.example.tareaactivitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ButtonActivity extends AppCompatActivity {

    ImageButton imageButtonStar;
    Chip chipButton;
    MaterialButton materialIconButton;
    FloatingActionButton fabAdd;

    public void irAMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_button);

        imageButtonStar = findViewById(R.id.imageButtonStar);
        chipButton = findViewById(R.id.chipButton);
        materialIconButton = findViewById(R.id.materialIconButton);
        fabAdd = findViewById(R.id.fabAdd);

        imageButtonStar.setOnClickListener(v -> Toast.makeText(ButtonActivity.this, "¡Botón de imagen Estrella presionado!", Toast.LENGTH_SHORT).show());

        chipButton.setOnClickListener(v -> Toast.makeText(ButtonActivity.this, "¡Botón Chip presionado!", Toast.LENGTH_SHORT).show());

        materialIconButton.setOnClickListener(v -> Toast.makeText(ButtonActivity.this, "¡Botón Material con Icono presionado!", Toast.LENGTH_SHORT).show());

        fabAdd.setOnClickListener(v -> Toast.makeText(ButtonActivity.this, "¡Botón Flotante Añadir presionado!", Toast.LENGTH_SHORT).show());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}