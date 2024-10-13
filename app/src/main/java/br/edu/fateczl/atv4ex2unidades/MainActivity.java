package br.edu.fateczl.atv4ex2unidades;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etNumero;
    private TextView tvErro;
    private TextView tvCentena;
    private TextView tvDezena;
    private TextView tvUnidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNumero = findViewById(R.id.etNumero);
        tvErro = findViewById(R.id.tvErro);
        tvCentena = findViewById(R.id.tvCentena);
        tvDezena = findViewById(R.id.tvDezena);
        tvUnidade = findViewById(R.id.tvUnidade);
        Button btnSeparar = findViewById(R.id.btnSeparar);
        btnSeparar.setOnClickListener(op -> separar());
    }

    private void separar() {
        tvErro.setText("");
        int numeroASeparar = Integer.parseInt(etNumero.getText().toString());
        if (numeroASeparar < 100 || numeroASeparar > 999){
            tvErro.setText(R.string.erro);
            tvCentena.setText("");
            tvDezena.setText("");
            tvUnidade.setText("");
        } else {
            int centena = numeroASeparar / 100;
            int dezena = (numeroASeparar % 100) / 10;
            int unidade = numeroASeparar % 10;
            String cent = "CENTENA = " + centena;
            String dez = "DEZENA = " + dezena;
            String uni = "UNIDADE = " + unidade;
            tvCentena.setText(cent);
            tvDezena.setText(dez);
            tvUnidade.setText(uni);
        }
        etNumero.setText("");
    }
}