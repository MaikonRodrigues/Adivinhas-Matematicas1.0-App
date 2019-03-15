package edmt.dev.adivinhas_matematicas;

import android.annotation.SuppressLint;
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

import java.util.Random;

public class Jogodos9Activity extends AppCompatActivity {

    private Button botProximo;
    private  int controle,  valorSoma;
    private TextView label1, label2, label3, label4, label5;
    private Random num_rand = new Random();

    //campos da propaganda
    AdView adView;

    // configuracao propaganda
    InterstitialAd mAdView;
    AdRequest adRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogodos9);

        //configurando adMob banner
        adView = findViewById(R.id.adView_jog9);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        //configurando banner grande
        mAdView = new InterstitialAd(Jogodos9Activity.this);
        mAdView.setAdUnitId(getString(R.string.admob_intersticial_id));

        adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                displayInterstitial();
            }

        });

        botProximo = (Button) findViewById(R.id.botao_proximo);
        controle = 0;
        valorSoma = num_rand.nextInt(10);
        label1 = (TextView) findViewById(R.id.textView1);
        label2 = (TextView) findViewById(R.id.textView2);
        label3 = (TextView) findViewById(R.id.textView3);
        label4 = (TextView) findViewById(R.id.textView4);
        label5 = (TextView) findViewById(R.id.textView5);




        botProximo.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                if(controle == 0){
                    label2.setVisibility(1); controle++;
                }
                else if(controle == 1){
                    label3.setVisibility(1); controle++;
                    label3.setText("Caso tenha obtido um número de dois digitos some-os\n(por exemplo, 15 = 1 + 5)");
                }
                else if(controle == 2){
                    label4.setVisibility(1); controle++;
                    label4.setText("Agora some "+valorSoma);
                }
                else if(controle == 3){
                    label1.setVisibility(View.INVISIBLE);
                    label3.setVisibility(View.INVISIBLE);
                    label4.setVisibility(View.INVISIBLE);


                    label2.setTextSize(40);
                    label2.setText("O resultado e : "+( 9 + valorSoma));
                    botProximo.setText("Voltar");
                    controle++;
                }else if(controle == 4){
                    startActivity(new Intent(Jogodos9Activity.this, MainActivity.class));
                }

            }
        });
    }

    private void displayInterstitial() {
        if (mAdView.isLoaded()){
            mAdView.show();
        }
    }
}
