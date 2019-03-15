package edmt.dev.adivinhas_matematicas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdvinhaActivity extends AppCompatActivity {

    private Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advinha);

        botao = (Button) findViewById(R.id.advinha_button);

        botao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity( new Intent(AdvinhaActivity.this, AdvinhaPrimTela_Activity.class ));
            }

        });
    }
}
