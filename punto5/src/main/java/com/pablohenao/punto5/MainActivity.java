package com.pablohenao.punto5;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;


public class MainActivity extends ActionBarActivity {

    int flag = 0;
    int flagh = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText eNombre = (EditText) findViewById(R.id.eNombre);
        final EditText eCorreo = (EditText) findViewById(R.id.eCorreo);
        final EditText eTelefono = (EditText) findViewById(R.id.eTel);
        final TextView tName = (TextView) findViewById(R.id.tNombre);
        final TextView tMail = (TextView) findViewById(R.id.tCorreo);
        final TextView tTel = (TextView) findViewById(R.id.tTel);
        final TextView tsexo = (TextView) findViewById(R.id.tsexo);
        final TextView hobbies = (TextView) findViewById(R.id.thobbie);
        final TextView tciudad = (TextView) findViewById(R.id.tciudad);
        Button boton = (Button) findViewById(R.id.boton);
        final Spinner spinner = (Spinner) findViewById(R.id.ciudad_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cities_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tName.setText(eNombre.getText());
                tMail.setText(eCorreo.getText());
                tTel.setText(eTelefono.getText());

                if (flag == 1) {
                    tsexo.setText("Hombre");
                }
                if (flag == 2) {
                    tsexo.setText("Mujer");
                }

                //hobbies.setText(String.valueOf(flagh));
                if (flagh == 1) {
                    hobbies.setText("Gaming");
                }
                if (flagh == 2) {
                    hobbies.setText("Deportes");
                }
                if (flagh == 4) {
                    hobbies.setText("Bailar");
                }
                if (flagh == 8) {
                    hobbies.setText("Leer");
                }
                if (flagh == 3) {
                    hobbies.setText("Gaming y Deportes");
                }
                if (flagh == 5) {
                    hobbies.setText("Gaming y Bailar");
                }
                if (flagh == 9) {
                    hobbies.setText("Gaming y Leer");
                }
                if (flagh == 6) {
                    hobbies.setText("Deportes y Bailar");
                }
                if (flagh == 10) {
                    hobbies.setText("Deportes y Leer");
                }
                if (flagh == 12) {
                    hobbies.setText("Bailar y Leer");
                }
                if (flagh == 7) {
                    hobbies.setText("Gaming, Deportes y Bailar");
                }
                if (flagh == 14) {
                    hobbies.setText("Deportes, Bailar y Leer");
                }
                if (flagh == 11) {
                    hobbies.setText("Gaming, Deportes y Leer");
                }
                if (flagh == 13) {
                    hobbies.setText("Gaming, Bailar y Leer");
                }
                if (flagh == 15) {
                    hobbies.setText("Gaming, Deportes, Bailar y Leer");
                }
                if (flagh == 0) {
                    hobbies.setText("Hobbies");
                }

                tciudad.setText(String.valueOf(spinner.getSelectedItem()));
            }
        });


        //TextView

    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(),"datePicker");

    }

    public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {


        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            // An item was selected. You can retrieve the selected item using
            // parent.getItemAtPosition(pos)
            TextView ciudad = (TextView) findViewById(R.id.tciudad);
            parent.getItemAtPosition(pos);
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker

            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it

            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {

            final TextView tnacimiento = (TextView) getActivity().findViewById(R.id.tnacimiento);
            String smonth = "";
            final String syear = String.valueOf(year);
            final String sday = String.valueOf(day);
            if(month==0){smonth="Enero";}
            if(month==1){smonth="Febrero";}
            if(month==2){smonth="Marzo";}
            if(month==3){smonth="Abril";}
            if(month==4){smonth="Mayo";}
            if(month==5){smonth="Junio";}
            if(month==6){smonth="Julio";}
            if(month==7){smonth="Agosto";}
            if(month==8){smonth="Septiembre";}
            if(month==9){smonth="Octubre";}
            if(month==10){smonth="Noviembre";}
            if(month==11){smonth="Diciembre";}
            Button boton = (Button) getActivity().findViewById(R.id.boton);
            final String finalSmonth = smonth;
            boton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tnacimiento.setText(sday+" / "+ finalSmonth +" / "+syear);
                }
            });

        }
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
        switch (view.getId()) {
            case R.id.ehombre:
                if (checked)
                    flag = 1;
                break;
            case R.id.emujer:
                if (checked)
                    flag = 2;
                break;
        }
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_h1:
                if (checked){flagh=flagh+1;}
                // Put some meat on the sandwich
                else{flagh=flagh-1;}
                // Remove the meat
                break;
            case R.id.checkbox_h2:
                if (checked){flagh=flagh+2;}
                // Cheese me
                else{flagh=flagh-2;}
                // I'm lactose intolerant
                break;
            case R.id.checkbox_h3:
                if (checked){flagh=flagh+4;}
                // Cheese me
                else{flagh=flagh-4;}
                // I'm lactose intolerant
                break;
            case R.id.checkbox_h4:
                if (checked){flagh=flagh+8;}
                // Cheese me
                else{flagh=flagh-8;}
                // I'm lactose intolerant
                break;
        }
    }


}