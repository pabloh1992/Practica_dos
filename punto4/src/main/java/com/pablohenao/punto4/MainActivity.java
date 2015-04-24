package com.pablohenao.punto4;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    int flag = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boton = (Button) findViewById(R.id.boton);
        final TextView tResultado = (TextView) findViewById(R.id.tResultado);

        final EditText ebase = (EditText) findViewById(R.id.ebase);
        final EditText ealtura = (EditText) findViewById(R.id.ealtura);
        final EditText eradio = (EditText) findViewById(R.id.eradio);
        final EditText elado = (EditText) findViewById(R.id.elado);

        RadioButton ecuadro = (RadioButton)findViewById(R.id.ecuadro);
        RadioButton etriangulo = (RadioButton)findViewById(R.id.etriangulo);
        RadioButton erectangulo = (RadioButton)findViewById(R.id.erectangulo);
        RadioButton ecirculo = (RadioButton)findViewById(R.id.ecirculo);

        ecuadro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                flag=1;
                elado.setEnabled(true);
                ealtura.setEnabled(false);
                eradio.setEnabled(false);
                ebase.setEnabled(false);
            }
        });

        etriangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                flag=2;
                elado.setEnabled(false);
                ealtura.setEnabled(true);
                eradio.setEnabled(false);
                ebase.setEnabled(true);
            }
        });

        erectangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                flag=3;
                elado.setEnabled(false);
                ealtura.setEnabled(true);
                eradio.setEnabled(false);
                ebase.setEnabled(true);
            }
        });

        ecirculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                flag=4;
                elado.setEnabled(false);
                ealtura.setEnabled(false);
                eradio.setEnabled(true);
                ebase.setEnabled(false);
            }
        });

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double ladod= 0;
                double alturad = 0;
                double radiod = 0;
                double based = 0;
                double resultado=0;

                if (elado.isEnabled()){
                    String lado = elado.getText().toString();
                    if(lado.isEmpty()){
                        elado.setError("Completar");
                        ladod=0;
                    }
                    else
                    ladod = Double.parseDouble(lado);
                }
                else if (ealtura.isEnabled() && ebase.isEnabled()){
                    //then the button is enabled.
                    String altura = ealtura.getText().toString();
                    String base = ebase.getText().toString();
                    if(altura.isEmpty()){
                        ealtura.setError("Completar");
                        alturad = 0;
                    }
                    else
                        alturad = Double.parseDouble(altura);
                    if(base.isEmpty()){

                        ebase.setError("Completar");
                        based=0;
                    }
                    else
                        based = Double.parseDouble(base);
                }
                else if (eradio.isEnabled()){

                    String radio = eradio.getText().toString();
                    if(radio.isEmpty()){
                        eradio.setError("Campo Vacio");
                        radiod=0;
                    }
                    else
                    radiod = Double.parseDouble(radio);
                }

                if(flag==1) {

                    resultado = ladod * ladod;
                }
                else if(flag==2) {

                    resultado = (based * alturad) / 2;
                }
                else if(flag==3) {

                    resultado = based * alturad;
                }
                else if(flag==4) {

                    resultado = (3.1416) * radiod * radiod;
                }
                else
                        resultado=flag;

                tResultado.setText(String.valueOf(resultado));

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
