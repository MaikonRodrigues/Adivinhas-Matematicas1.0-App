package edmt.dev.adivinhas_matematicas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AdvinhaPrimTela_Activity extends AppCompatActivity {
    private Button botSim, botNao;
    private TextView Q1, Q2, Q3, Q4, Q5, Q6, Q7, Q8, Q9, Q10, Q11, Q12, Q13, Q14, Q15, Q16,pergunta;
    public int resFinal, conTel;
    private String toastMensagem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advinha_tela1_);

        pergunta = (TextView) findViewById(R.id.pergunta);
        resFinal = 0; conTel = 0;
        botSim = (Button) findViewById(R.id.botao_sim);
        botNao = (Button) findViewById(R.id.botao_nao);

        final Bundle dataBundle = new Bundle();
        final Intent intent = new Intent(AdvinhaPrimTela_Activity.this, TelaResActivity.class);

        Q1 = (TextView) findViewById(R.id.textViewQ1);   Q2 = (TextView) findViewById(R.id.textViewQ2);
        Q3 = (TextView) findViewById(R.id.textViewQ3);   Q4 = (TextView) findViewById(R.id.textViewQ4);
        Q5 = (TextView) findViewById(R.id.textViewQ5);   Q6 = (TextView) findViewById(R.id.textViewQ6);
        Q7 = (TextView) findViewById(R.id.textViewQ7);   Q8 = (TextView) findViewById(R.id.textViewQ8);
        Q9 = (TextView) findViewById(R.id.textViewQ9);   Q10 = (TextView) findViewById(R.id.textViewQ10);
        Q11 = (TextView) findViewById(R.id.textViewQ11); Q12 = (TextView) findViewById(R.id.textViewQ12);
        Q13 = (TextView) findViewById(R.id.textViewQ13); Q14 = (TextView) findViewById(R.id.textViewQ14);
        Q15 = (TextView) findViewById(R.id.textViewQ15); Q16 = (TextView) findViewById(R.id.textViewQ16);


        Toast.makeText(getApplicationContext(),"Vou advinhar seu pensamento" , Toast.LENGTH_LONG).show();

        botSim.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                    if(conTel == 0){

                        resFinal = 1; conTel++;
                        Q1.setText("2"); Q2.setText("3"); Q3.setText("6"); Q4.setText("7");
                        Q5.setText("10"); Q6.setText("11"); Q7.setText("14"); Q8.setText("15");
                        Q9.setText("18"); Q10.setText("19"); Q11.setText("22"); Q12.setText("23");
                        Q13.setText("26"); Q14.setText("27"); Q15.setText("30"); Q16.setText("31");
                        pergunta.setText("Pergunta 2 - O número escolhido está aqui?");


                    }else if(conTel == 1){

                        resFinal = resFinal + 2; conTel++;
                        Q1.setText("4"); Q2.setText("5"); Q3.setText("6"); Q4.setText("7");
                        Q5.setText("12"); Q6.setText("13"); Q7.setText("14"); Q8.setText("15");
                        Q9.setText("20"); Q10.setText("21"); Q11.setText("22"); Q12.setText("23");
                        Q13.setText("28"); Q14.setText("29"); Q15.setText("30"); Q16.setText("31");
                        pergunta.setText("Pergunta 3 - Seu número está aqui?");



                    }else if(conTel == 2){

                        resFinal = resFinal + 4; conTel++;
                        Q1.setText("8"); Q2.setText("9"); Q3.setText("10"); Q4.setText("11");
                        Q5.setText("12"); Q6.setText("13"); Q7.setText("14"); Q8.setText("15");
                        Q9.setText("24"); Q10.setText("25"); Q11.setText("26"); Q12.setText("27");
                        Q13.setText("28"); Q14.setText("29"); Q15.setText("30"); Q16.setText("31");
                        pergunta.setText("Pergunta 4 - O número escolhido está aqui?");

                        if(resFinal >= 4)
                            Toast.makeText(getApplicationContext(),"Já sei que nao e o número:" + (resFinal-1), Toast.LENGTH_LONG).show();

                    }else if(conTel == 3){

                        resFinal = resFinal + 8; conTel++;
                        Q1.setText("16"); Q2.setText("17"); Q3.setText("18"); Q4.setText("19");
                        Q5.setText("20"); Q6.setText("21"); Q7.setText("22"); Q8.setText("23");
                        Q9.setText("24"); Q10.setText("25"); Q11.setText("26"); Q12.setText("27");
                        Q13.setText("28"); Q14.setText("29"); Q15.setText("30"); Q16.setText("31");
                        pergunta.setText("Pergunta 5 - Seu número está aqui?");


                    }else if(conTel == 4){
                        resFinal = resFinal +16; conTel++;
                        dataBundle.putInt("valor_enviado",resFinal);
                        intent.putExtra("result",resFinal);
                        intent.putExtras(dataBundle);
                        startActivity(intent);
                    }
            }

        });

        botNao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(conTel == 0){
                    conTel++;
                    Q1.setText("2"); Q2.setText("3"); Q3.setText("6"); Q4.setText("7");
                    Q5.setText("10"); Q6.setText("11"); Q7.setText("14"); Q8.setText("15");
                    Q9.setText("18"); Q10.setText("19"); Q11.setText("22"); Q12.setText("23");
                    Q13.setText("26"); Q14.setText("27"); Q15.setText("30"); Q16.setText("31");





                }else if(conTel == 1){
                    conTel++;
                    Q1.setText("4"); Q2.setText("5"); Q3.setText("6"); Q4.setText("7");
                    Q5.setText("12"); Q6.setText("13"); Q7.setText("14"); Q8.setText("15");
                    Q9.setText("20"); Q10.setText("21"); Q11.setText("22"); Q12.setText("23");
                    Q13.setText("28"); Q14.setText("29"); Q15.setText("30"); Q16.setText("31");
                    pergunta.setText("Pergunta 3 - Seu número está aqui?");

                }else if(conTel == 2){
                    conTel++;
                    Q1.setText("8"); Q2.setText("9"); Q3.setText("10"); Q4.setText("11");
                    Q5.setText("12"); Q6.setText("13"); Q7.setText("14"); Q8.setText("15");
                    Q9.setText("24"); Q10.setText("25"); Q11.setText("26"); Q12.setText("27");
                    Q13.setText("28"); Q14.setText("29"); Q15.setText("30"); Q16.setText("31");
                    pergunta.setText("Pergunta 4 - O número escolhido está aqui?");

                }else if(conTel == 3){
                    conTel++;
                    Q1.setText("16"); Q2.setText("17"); Q3.setText("18"); Q4.setText("19");
                    Q5.setText("20"); Q6.setText("21"); Q7.setText("22"); Q8.setText("23");
                    Q9.setText("24"); Q10.setText("25"); Q11.setText("26"); Q12.setText("27");
                    Q13.setText("28"); Q14.setText("29"); Q15.setText("30"); Q16.setText("31");
                    pergunta.setText("Pergunta 5 - Seu número está aqui?");

                        Toast.makeText(getApplicationContext(),"O número pensado não passa de 23", Toast.LENGTH_LONG).show();


                }else if(conTel == 4){
                    dataBundle.putInt("valor_enviado",resFinal);
                    intent.putExtra("result",resFinal);
                    intent.putExtras(dataBundle);
                    startActivity(intent);
                }

            }
        });
    }
}