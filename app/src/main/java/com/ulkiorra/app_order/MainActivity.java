package com.ulkiorra.app_order;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2, editText3, editText4;
    Button btnOrdemLida, btnOrdemCrescente, btnOrdemDecrescente;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        btnOrdemLida = findViewById(R.id.btnOrdemLida);
        btnOrdemCrescente = findViewById(R.id.btnOrdemCrescente);
        btnOrdemDecrescente = findViewById(R.id.btnOrdemDecrescente);
        txtResultado = findViewById(R.id.txtResultado);

        btnOrdemLida.setOnClickListener(view -> mostrarOrdemLida());
        btnOrdemCrescente.setOnClickListener(view -> ordenarECarregar(true));
        btnOrdemDecrescente.setOnClickListener(view -> ordenarECarregar(false));
    }

    private void mostrarOrdemLida() {
        String resultado = editText1.getText().toString() + ", " +
                editText2.getText().toString() + ", " +
                editText3.getText().toString() + ", " +
                editText4.getText().toString();
        txtResultado.setText(resultado);
    }

    private void ordenarECarregar(boolean crescente) {
        List<Integer> valores = new ArrayList<>();
        valores.add(Integer.valueOf(editText1.getText().toString()));
        valores.add(Integer.valueOf(editText2.getText().toString()));
        valores.add(Integer.valueOf(editText3.getText().toString()));
        valores.add(Integer.valueOf(editText4.getText().toString()));

        if (crescente) {
            Collections.sort(valores);
        } else {
            valores.sort(Collections.reverseOrder());
        }

        // Convertendo a lista de volta para strings para exibição
        List<String> valoresString = new ArrayList<>();
        for (Integer valor : valores) {
            valoresString.add(String.valueOf(valor));
        }

        txtResultado.setText(valoresString.toString());
    }
}