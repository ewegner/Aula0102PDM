package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txtRotulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TESTE", "Passei pelo onCreate!");

        Button btnEventoClique2 = findViewById(R.id.btnEventoClique2);

        Button btnEventoClique3 = findViewById(R.id.btnEventoClique3);
        btnEventoClique3.setOnClickListener(this);

        Button btnEventoClique4 = findViewById(R.id.btnEventoClique4);
        btnEventoClique4.setOnClickListener(this);

        txtRotulo = findViewById(R.id.txtRotulo);

        btnEventoClique2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TESTE", "Botão eventoClique2 acionado!");
                txtRotulo.setText("Camaleão");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TESTE", "Passei pelo onStart!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TESTE", "Passei pelo onResume!");
    }

    public void eventoClique1(View view) {
        Log.d("TESTE", "Botão eventoClique1 acionado!");
        String aux = txtRotulo.getText().toString();
        Log.d("TESTE", aux);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnEventoClique3) {
            Log.d("TESTE", "Botão eventoClique3 acionado!");
        } else {
            if (view.getId() == R.id.btnEventoClique4) {
                Log.d("TESTE", "Botão eventoClique4 acionado!");
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("valor", "Teste para tela 2");
                intent.putExtra("chave", true);
                intent.putExtra("valor1", 1);
                intent.putExtra("valor2", 2);
                startActivityForResult(intent, 0);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (resultCode ==  RESULT_OK) {
                int somatoriaTelaAnterior = data.getIntExtra("soma", 0);
                Toast.makeText(MainActivity.this, String.valueOf(somatoriaTelaAnterior), Toast.LENGTH_SHORT).show();
            } else {
                if (resultCode == RESULT_CANCELED) {
                    Toast.makeText(MainActivity.this, "Cancelado", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}