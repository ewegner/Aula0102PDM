package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    int valor1 = 0, valor2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView txtRotulo2 =findViewById(R.id.txtRotulo2);

        Intent intent = getIntent();
        String conteudo = intent.getStringExtra("valor");
        boolean chave = intent.getBooleanExtra("chave", false);
        if (chave) {
            txtRotulo2.setText(conteudo);
        } else {
            txtRotulo2.setText("Chave booleana errada");
        }

        valor1 = intent.getIntExtra("valor1", 0);
        valor2 = intent.getIntExtra("valor2", 0);
    }

    public void openClick(View view) {
        Uri uri = Uri.parse("https://unisc.br");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void somaClick(View view) {
        int soma = valor1 + valor2;
        Intent intent = getIntent();
        intent.putExtra("soma", soma);
        setResult(RESULT_OK, intent);
        onBackPressed();
    }
}