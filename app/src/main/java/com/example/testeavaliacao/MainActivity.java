package com.example.testeavaliacao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private TextView txtValorAvaliacao;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);
        addListenerOnRatingBar();
        addListenerOnButton();
    }

    public void addListenerOnRatingBar(){
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        txtValorAvaliacao = (TextView) findViewById(R.id.txtValorAvaliacao);

        //Se o valor de avaliação mudar,
        //exiba o valor de avaliação atual no resultado (textview) automaticamente:
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float avaliacao, boolean fromUser) {
                txtValorAvaliacao.setText(String.valueOf(avaliacao));
            }
        });
    }

    public void addListenerOnButton() {
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        //Se o botão for clicado, exiba o valor de avaliação.
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,
                        String.valueOf(ratingBar.getRating()),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}