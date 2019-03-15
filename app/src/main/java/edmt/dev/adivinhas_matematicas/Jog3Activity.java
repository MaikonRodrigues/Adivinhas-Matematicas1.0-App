package edmt.dev.adivinhas_matematicas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Jog3Activity extends AppCompatActivity {

    private Button botProxJogo3;
    private TextView label1, label2, label3,label4,label5;
    private EditText editText;
    private int controle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo3);

        botProxJogo3 = (Button) findViewById(R.id.botao_proximo);
        label1 = (TextView) findViewById(R.id.textView1);
        label2 = (TextView) findViewById(R.id.textView2);
        label3 = (TextView) findViewById(R.id.textView3);
        label4 = (TextView) findViewById(R.id.textView4);
        label5 = (TextView) findViewById(R.id.textView5);
        editText = (EditText) findViewById(R.id.editText5);


        controle = 0;

        botProxJogo3.setOnClickListener(new View.OnClickListener() {
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
                    editText.setVisibility(1);
                }else if(controle == 4){
                    label1.setVisibility(View.INVISIBLE);
                    label2.setVisibility(View.INVISIBLE);
                    label4.setVisibility(View.INVISIBLE);
                    label5.setVisibility(View.INVISIBLE);
                    editText.setVisibility(View.INVISIBLE);
                    //label3.setTextSize(40);

                    int val = Integer.parseInt(editText.getText().toString());

                    label3.setText("Você pensou no : "+ val /3 );
                    botProxJogo3.setText("Voltar");
                    controle++;
                }else if(controle == 5){
                    startActivity(new Intent(Jog3Activity.this, MainActivity.class));
                }
            }
        });
    }
}
