package edmt.dev.adivinhas_matematicas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class AniversarioActivity extends AppCompatActivity {

    //campos do laypout da adivinhação
    private TextView labelTexto;
    private Button botaoProximo;
    private int contador, somaFinal, contCaracter, idade, mes, visibilidade;
    private EditText resultadoConta;
    private String somaFinalString;
    private char[] vetor;
    private StringBuilder part1;
    private StringBuilder part2;
    private String nomeMes;

    //campos da propaganda
    AdView adView;

    //Campos do layout da calculadora
    TextView textView;
    String currentString = "0", previusString = null;
    boolean isTempStringShown = false;
    int currentopperand = 0;

    // configuracao propaganda
    InterstitialAd mAdView;
    AdRequest adRequest;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aniversario);

        //configurando adMob banner
        adView = findViewById(R.id.adView_aniver);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        //configurando banner grande
        mAdView = new InterstitialAd(AniversarioActivity.this);
        mAdView.setAdUnitId(getString(R.string.admob_intersticial_id));

        adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                displayInterstitial();
            }

        });


        //pegando valores para a adivinhaçao
        labelTexto = (TextView) findViewById(R.id.textViewlabel1);
        botaoProximo = (Button) findViewById(R.id.btproximo);
        resultadoConta = (EditText) findViewById(R.id.resultSoma);
        contador = 0; visibilidade = 1;
        part1 = new StringBuilder();
        part2 = new StringBuilder();

        labelTexto.setText("Pense no número do mês do seu aniversário "+ "\n" + "(ex: Abril = 4)" );





        //BOTÃO PROXIMO
        botaoProximo.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (contador == 0) {
                    labelTexto.setText("Multiplique o número por 2");
                    contador++;
                } else if (contador == 1) {
                    labelTexto.setText("Some 5 ao resultado");
                    contador++;
                } else if (contador == 2) {
                    labelTexto.setText("Multiplique por 50");
                    contador++;
                } else if (contador == 3) {
                    labelTexto.setText("some sua idade ao resultado");
                    contador++;
                } else if (contador == 4) {
                    labelTexto.setText("Informe o resultado que direi sua idade e o mês do seu aniversário");
                    resultadoConta.setVisibility(View.VISIBLE);
                    contador++;
                } else if (contador == 5) {
                    if(resultadoConta.getText().length() == 0){
                        Toast.makeText(AniversarioActivity.this, "Informe o resultado", Toast.LENGTH_LONG).show();
                    }else{
                        somaFinal = Integer.parseInt(resultadoConta.getText().toString());
                        somaFinal = (somaFinal - 250);

                        //Separando caracteres com metodo toCharArray();
                        somaFinalString = String.valueOf(somaFinal);
                        vetor = somaFinalString.toCharArray();


                        contCaracter = resultadoConta.getText().toString().length();
                        if (contCaracter == 3) {
                            //pegar o primeiro numero como mes e os dois ultimos como idade
                            part1.append(vetor[0]);
                            mes = Integer.parseInt(part1.toString());
                            part2.append(vetor[1]).append(vetor[2]);
                            idade = Integer.parseInt(part2.toString());

                            if (mes == 11) nomeMes = "Novembro";
                            else if (mes == 1) nomeMes = "Janeiro";
                            else if (mes == 2) nomeMes = "Fervereiro";
                            else if (mes == 12) nomeMes = "Dezembro";
                            else if (mes == 3) nomeMes = "Março";
                            else if (mes == 4) nomeMes = "Abril";
                            else if (mes == 5) nomeMes = "Maio";
                            else if (mes == 6) nomeMes = "Junho";
                            else if (mes == 7) nomeMes = "Julho";
                            else if (mes == 8) nomeMes = "Agosto";
                            else if (mes == 9) nomeMes = "Setembro";
                            else if (mes == 10) nomeMes = "Outubro";

                        } else {
                            //pegr os dois primeiros numeros como mes e os dois ultimos como idade
                            part1.append(vetor[0]).append(vetor[1]);
                            mes = Integer.parseInt(part1.toString());
                            part2.append(vetor[2]).append(vetor[3]);
                            idade = Integer.parseInt(part2.toString());

                            if (mes == 11) nomeMes = "Novembro";
                            else if (mes == 1) nomeMes = "Janeiro";
                            else if (mes == 2) nomeMes = "Fervereiro";
                            else if (mes == 12) nomeMes = "Dezembro";
                            else if (mes == 3) nomeMes = "Março";
                            else if (mes == 4) nomeMes = "Abril";
                            else if (mes == 5) nomeMes = "Maio";
                            else if (mes == 6) nomeMes = "Junho";
                            else if (mes == 7) nomeMes = "Julho";
                            else if (mes == 8) nomeMes = "Agosto";
                            else if (mes == 9) nomeMes = "Setembro";
                            else if (mes == 10) nomeMes = "Outubro";

                        }
                        if (nomeMes == null){
                            labelTexto.setText("Seus calculos estão errados, por favor tente novamente");
                            resultadoConta.setVisibility(View.INVISIBLE);
                            botaoProximo.setText("voltar");
                            contador++;
                        }else {
                            labelTexto.setText("Você tem " + idade + " anos e nasceu em " + nomeMes);
                            resultadoConta.setVisibility(View.INVISIBLE);
                            botaoProximo.setText("voltar");
                            contador++;
                        }
                    }

                } else if (contador == 6) {
                    startActivity(new Intent(AniversarioActivity.this, MainActivity.class));
                }
            }
        });

        //Configuraçoes da calculadora

        textView = (TextView) findViewById(R.id.textView);
        int numberButtons[] = {R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9};
        AniversarioActivity.NumberButtonClickListener numberClickListener = new AniversarioActivity.NumberButtonClickListener();

        for (int id : numberButtons) {
            View v = findViewById(id);
            v.setOnClickListener((View.OnClickListener) numberClickListener);
        }
        int opperandButtons[] = {R.id.buttonPlus, R.id.buttonMinus, R.id.buttonDivide, R.id.buttonTimes, R.id.buttonDecimal, R.id.buttonClear, R.id.buttonEquals};
        AniversarioActivity.OpperandButtonClickListener oppClickListener = new AniversarioActivity.OpperandButtonClickListener();

        for (int id : opperandButtons) {
            View v = findViewById(id);
            v.setOnClickListener((View.OnClickListener) oppClickListener);
        }
        setCurrentString("0");

    }

    private void displayInterstitial() {
        if (mAdView.isLoaded()){
            mAdView.show();
        }
    }

    void setCurrentString(String s) {

        currentString = s;
        textView.setText(s);
    }

    class NumberButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            if (isTempStringShown) {
                previusString = currentString;
                currentString = "0";
                isTempStringShown = false;
            }

            String text = (String) ((Button) v).getText();
            if (currentString.equals("0")) setCurrentString(text);
            else setCurrentString(currentString + text);
        }
    }

    class OpperandButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            int id = v.getId();
            if (id == R.id.buttonClear) {

                isTempStringShown = false;
                setCurrentString("0");
                previusString = null;
            }

            if (id == R.id.buttonDecimal)
                if (!currentString.contains(".")) setCurrentString(currentString + ".");

            if (id == R.id.buttonPlus || id == R.id.buttonMinus || id == R.id.buttonTimes || id == R.id.buttonDivide) {

                currentopperand = id;
                previusString = currentString;
                isTempStringShown = true;
            }
            if (id == R.id.buttonEquals) {

                double curr = Double.parseDouble(currentString);
                double result = 0;

                if (previusString != null) {

                    double prev = Double.parseDouble(previusString);
                    switch (currentopperand) {
                        case R.id.buttonPlus:
                            result = prev + curr;
                            break;
                        case R.id.buttonMinus:
                            result = prev - curr;
                            break;
                        case R.id.buttonTimes:
                            result = prev * curr;
                            break;
                        case R.id.buttonDivide:
                            result = prev / curr;
                            break;
                    }
                }
                setCurrentString(Double.toString(result));
            }
        }
    }
}

