package com.pablohenao.punto3;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    double resultado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boton = (Button) findViewById(R.id.boton);
        final TextView tDefinitiva = (TextView) findViewById(R.id.tDefinitiva);
        final EditText equices = (EditText) findViewById(R.id.equices);
        final EditText eexposiciones = (EditText) findViewById(R.id.eexposiciones);
        final EditText elab = (EditText) findViewById(R.id.elab);
        final EditText eproyecto = (EditText) findViewById(R.id.eproyecto);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double num1d=0;
                double num2d=0;
                double num3d=0;
                double num4d=0;
                int flag=0;

                String num1s = equices.getText().toString();
                if(num1s.isEmpty()){
                    equices.setError("Nota no válida");
                    num1d = 0;
                    flag=1;

                }
                else
                    num1d = Double.parseDouble(num1s);
                    if(num1d>5){
                        flag=1;
                        equices.setError("Nota no válida");
                    }

                String num2s = eexposiciones.getText().toString();
                if(num2s.isEmpty()){
                    eexposiciones.setError("Nota no válida");
                    num2d = 0;
                    flag=1;
                }
                else
                    num2d = Double.parseDouble(num2s);
                if(num2d>5){
                    flag=1;
                    eexposiciones.setError("Nota no válida");
                }

                String num3s = elab.getText().toString();

                if(num3s.isEmpty()){
                    elab.setError("Nota no válida");
                    num4d = 0;
                    flag=1;

                }
                else
                    num3d = Double.parseDouble(num3s);
                if(num3d>5){
                    flag=1;
                    elab.setError("Nota no válida");
                }

                String num4s = eproyecto.getText().toString();

                if(num4s.isEmpty()){
                    eproyecto.setError("Nota no válida");
                    num4d = 0;
                    flag=1;

                }
                else
                    num4d = Double.parseDouble(num4s);
                if(num4d>5){
                    flag=1;
                    eproyecto.setError("Nota no válida");
                }

                if(flag==0)
                    resultado = num1d*0.15+num2d*0.1+num3d*0.4+num4d*0.35;
                else
                    resultado = 0;
                tDefinitiva.setText(String.valueOf(resultado));
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
