package edmt.dev.adivinhas_matematicas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TelaResActivity extends AppCompatActivity {

    public int result;
    String resultString;
    private TextView resultado;
    private Button inicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_res);

        Bundle extras = getIntent().getExtras();
        result = extras.getInt("result");
        inicio = (Button) findViewById(R.id.botaoInicio);
        Log.i("Valor_enviado","valor recebido:" +result);
        resultado = (TextView) findViewById(R.id.resTextView);
        resultString = String.valueOf(result);
        resultado.setText(resultString);

        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(TelaResActivity.this, MainActivity.class ));
            }
        });
    }
}
