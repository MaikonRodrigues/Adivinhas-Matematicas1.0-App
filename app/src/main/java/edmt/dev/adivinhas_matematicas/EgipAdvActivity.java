package edmt.dev.adivinhas_matematicas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class EgipAdvActivity extends AppCompatActivity {

    private int contador, voltar, controle,  i, resultado, vl1, vl2, vl3, vl4, vl5, vl6, vl7;
    private Button btProximo, btImpar, btPar, btIgual1;
    private TextView labelPrincipal;

    //campos da propaganda
    AdView adView;

    // configuracao propaganda
    InterstitialAd mAdView;
    AdRequest adRequest;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egip_adv);

        //configurando adMob banner
        adView = findViewById(R.id.adView_jog9);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        //configurando banner grande
        mAdView = new InterstitialAd(EgipAdvActivity.this);
        mAdView.setAdUnitId(getString(R.string.admob_intersticial_id));

        adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener() {
           @Override
           public void onAdLoaded() {
              displayInterstitial();
           }
        });

        contador       = 0; resultado = 0; controle = 0; voltar = 0;
        btPar          = (Button)   findViewById(R.id.btNao);
        btImpar        = (Button)   findViewById(R.id.btSim);
        btProximo      = (Button)   findViewById(R.id.btproximo);
        btIgual1       = (Button)   findViewById(R.id.igual1);
        labelPrincipal = (TextView) findViewById(R.id.textViewlabelPrincipal);

        btProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (voltar == 1){
                    voltar = 0;
                    startActivity(new Intent(EgipAdvActivity.this, MainActivity.class));
                }else if (contador == 0){
                    labelPrincipal.setText("O número que você escolheu e par ou impar ?");
                    btProximo.setVisibility(View.INVISIBLE);
                    btImpar.setVisibility(View.VISIBLE);
                    btPar.setVisibility(View.VISIBLE); contador++;
                }else{
                    labelPrincipal.setText("O resultado e um número par ou impar ?");
                    btProximo.setVisibility(View.INVISIBLE);
                    btImpar.setVisibility(View.VISIBLE);
                    btPar.setVisibility(View.VISIBLE);
                }



            }
        });

        btImpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                labelPrincipal.setText("Subtraia 1 e divida novamente por 2");
                btProximo.setVisibility(View.VISIBLE);
                btImpar.setVisibility(View.INVISIBLE);
                btPar.setVisibility(View.INVISIBLE);
                controle++;

                if (controle == 1) resultado =+ 1;
                else if (controle == 2) resultado = resultado + 2;
                else if (controle == 3) resultado = resultado + 4;
                else if (controle == 4) resultado = resultado + 8;
                else if (controle == 5) resultado = resultado + 16;
                else if (controle == 6) resultado = resultado + 32;
                else if (controle == 7) resultado = resultado + 64;

            }
        });
        btPar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                labelPrincipal.setText("Divida novamente por 2");
                btProximo.setVisibility(View.VISIBLE);
                btImpar.setVisibility(View.INVISIBLE);
                btPar.setVisibility(View.INVISIBLE);
                controle++;
            }
        });
        btIgual1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btProximo.setVisibility(View.VISIBLE);
                btImpar.setVisibility(View.INVISIBLE);
                btPar.setVisibility(View.INVISIBLE);

                labelPrincipal.setText("O número que você pensou foi: " + resultado);
                btProximo.setText("Voltar");
                voltar = 1;
            }
        });

    }

    private void displayInterstitial() {
        if (mAdView.isLoaded()){
            mAdView.show();
        }
    }
}


