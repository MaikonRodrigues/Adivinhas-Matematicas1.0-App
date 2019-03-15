package edmt.dev.adivinhas_matematicas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class Jogo2Activity extends AppCompatActivity {


    private Button botProximo;
    private  int controle, resultado, valorSoma;
    private TextView label1, label2, label3, label4, label5;
    private  Random num_rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo2_ultima_tela);

        botProximo = (Button) findViewById(R.id.botao_proximo);
        controle = 0;
        valorSoma = num_rand.nextInt(10);
        valorSoma = valorSoma * 2;
        resultado = valorSoma / 2;
        label1 = (TextView) findViewById(R.id.textView1);
        label2 = (TextView) findViewById(R.id.textView2);
        label3 = (TextView) findViewById(R.id.textView3);
        label4 = (TextView) findViewById(R.id.textView4);
        label5 = (TextView) findViewById(R.id.textView5);

        label3.setText("Some o resultado com "+ valorSoma);

        botProximo.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                if(controle == 0){
                    label2.setVisibility(1); controle++;
                }
                else if(controle == 1){
                    label3.setVisibility(1); controle++;
                }
                else if(controle == 2){
                    label4.setVisibility(1); controle++;
                }else if(controle == 3){
                    label5.setVisibility(1);  controle++;
                }else if(controle == 4){
                    label1.setVisibility(View.INVISIBLE);
                    label2.setVisibility(View.INVISIBLE);
                    label4.setVisibility(View.INVISIBLE);
                    label5.setVisibility(View.INVISIBLE);

                    label3.setTextSize(40);
                    label3.setText("O resultado e : " + resultado);
                    botProximo.setText("Voltar");
                    controle++;
                }else if(controle == 5){
                    startActivity(new Intent(Jogo2Activity.this, MainActivity.class));
                }

            }
        });
    }
}
