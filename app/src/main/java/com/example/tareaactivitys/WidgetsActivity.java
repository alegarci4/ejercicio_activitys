package com.example.tareaactivitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WidgetsActivity extends AppCompatActivity {

    CheckBox checkBoxPlantarArboles, checkBoxRegarPlantas, checkBoxJugarFutbol;
    Button btnVerificarSeleccion;

    public void irAMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_widgets);

        checkBoxPlantarArboles = findViewById(R.id.checkBoxPlantarArboles);
        checkBoxRegarPlantas = findViewById(R.id.checkBoxRegarPlantas);
        checkBoxJugarFutbol = findViewById(R.id.checkBoxJugarFutbol);
        btnVerificarSeleccion = findViewById(R.id.btnVerificarSeleccion);

        btnVerificarSeleccion.setOnClickListener(v -> {
            StringBuilder seleccionadas = new StringBuilder("Opciones seleccionadas:\n");
            int count = 0;

            if (checkBoxPlantarArboles.isChecked()) {
                seleccionadas.append("- Plantar árboles\n");
                count++;
            }
            if (checkBoxRegarPlantas.isChecked()) {
                seleccionadas.append("- Regar las plantas\n");
                count++;
            }
            if (checkBoxJugarFutbol.isChecked()) {
                seleccionadas.append("- Jugar fútbol\n");
                count++;
            }

            if (count == 0) {
                Toast.makeText(WidgetsActivity.this, "Ninguna opción seleccionada", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(WidgetsActivity.this, seleccionadas.toString(), Toast.LENGTH_LONG).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}