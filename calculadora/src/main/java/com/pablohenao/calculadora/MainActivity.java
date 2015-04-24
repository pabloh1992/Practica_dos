package com.pablohenao.calculadora;

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
    double resultado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boton = (Button) findViewById(R.id.boton);
        final TextView tResultado = (TextView) findViewById(R.id.tResultado);
        final EditText enum1 = (EditText) findViewById(R.id.enum1);
        final EditText enum2 = (EditText) findViewById(R.id.enum2);
        RadioButton esuma = (RadioButton)findViewById(R.id.esuma);
        RadioButton eresta = (RadioButton)findViewById(R.id.eresta);
        RadioButton emultiplicacion = (RadioButton)findViewById(R.id.emultiplicacion);
        RadioButton edivision = (RadioButton)findViewById(R.id.edivision);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double num1d=0;
                double num2d=0;

                String num1s = enum1.getText().toString();
                if(num1s.isEmpty()){
                    enum1.setError("Completar");
                    num1d = 0;
                    num2d=0;
                }
                else
                    num1d = Double.parseDouble(num1s);

                String num2s = enum2.getText().toString();
                if(num2s.isEmpty()){
                    enum2.setError("Completar");
                    num1d=0;
                    num2d = 0;
                }
                else
                    num2d = Double.parseDouble(num2s);

                switch (flag){
                    case 1:
                        resultado=num1d+num2d;
                        break;
                    case 2:
                        resultado=num1d-num2d;
                        break;
                    case 3:
                        resultado=num1d*num2d;
                        break;
                    case 4:
                       resultado=num1d/num2d;
                        break;
                    default:
                        break;
                }
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

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.esuma:
                if (checked)
                    flag=1;
                    break;
            case R.id.eresta:
                if (checked)
                    flag=2;
                    break;
            case R.id.emultiplicacion:
                if (checked)
                    flag=3;
                    break;
            case R.id.edivision:
                if (checked)
                    flag=4;
                    break;
        }
    }
}

//String snum1 = num1.getText().toString();
//double dnumq = Double.parseDouble(snumq);