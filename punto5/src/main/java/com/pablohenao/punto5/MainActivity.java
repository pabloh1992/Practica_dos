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
    int checkflag = 0;

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

                if (checkflag == 1)
                    hobbies.setText("Deporte");

                if (checkflag == 2)
                    hobbies.setText("Leer");

                if (checkflag == 4)
                    hobbies.setText("Videojuegos");

                if (checkflag == 8)
                    hobbies.setText("Cocinar");

                if (checkflag == 3)
                    hobbies.setText("Deporte y Leer");

                if (checkflag == 5)
                    hobbies.setText("Deporte y Videojuegos");

                if (checkflag == 9)
                    hobbies.setText("Deporte y Cocinar");

                if (checkflag == 6)
                    hobbies.setText("Leer y Videojuegos");

                if (checkflag == 10)
                    hobbies.setText("Leer y Cocinar");

                if (checkflag == 12)
                    hobbies.setText("Videojuegos y Cocinar");

                if (checkflag == 7)
                    hobbies.setText("Deporte, Leer y Videojuegos");

                if (checkflag == 14)
                    hobbies.setText("Leer, Videojuegos y Cocinar");

                if (checkflag == 11)
                    hobbies.setText("Deporte, Leer y Cocinar");

                if (checkflag == 13)
                    hobbies.setText("Deporte, Videojuegos y Cocinar");

                if (checkflag == 15)
                    hobbies.setText("Deporte, Leer, Videojuegos y Cocinar");

                if (checkflag == 0)
                    hobbies.setText("Hobbies");


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
            if(month==0){smonth="01";}
            if(month==1){smonth="02";}
            if(month==2){smonth="03";}
            if(month==3){smonth="04";}
            if(month==4){smonth="05";}
            if(month==5){smonth="06";}
            if(month==6){smonth="07";}
            if(month==7){smonth="08";}
            if(month==8){smonth="09";}
            if(month==9){smonth="10";}
            if(month==10){smonth="11";}
            if(month==11){smonth="12";}

            final String finalSmonth = smonth;
                    tnacimiento.setText(sday+" / "+ finalSmonth +" / "+syear);

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
                if (checked)
                    checkflag=checkflag+1;

                else
                    checkflag=checkflag-1;

                break;
            case R.id.checkbox_h2:
                if (checked)
                    checkflag=checkflag+2;

                else
                    checkflag=checkflag-2;

                break;
            case R.id.checkbox_h3:
                if (checked)
                    checkflag=checkflag+4;

                else
                    checkflag=checkflag-4;

                break;
            case R.id.checkbox_h4:
                if (checked)
                    checkflag=checkflag+8;

                else
                    checkflag=checkflag-8;

                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);


        final TextView tName = (TextView) findViewById(R.id.tNombre);
        final TextView tMail = (TextView) findViewById(R.id.tCorreo);
        final TextView tTel = (TextView) findViewById(R.id.tTel);
        final TextView tsexo = (TextView) findViewById(R.id.tsexo);
        final TextView hobbies = (TextView) findViewById(R.id.thobbie);
        final TextView tciudad = (TextView) findViewById(R.id.tciudad);
        final TextView tnacimiento = (TextView) findViewById(R.id.tnacimiento);


        outState.putInt("banderacheck",checkflag);
        outState.putString("sexo",tsexo.getText().toString());
        outState.putString("hobb",hobbies.getText().toString());
        outState.putString("ciudad",tciudad.getText().toString());
        outState.putString("fecha",tnacimiento.getText().toString());
        outState.putString("nomb",tName.getText().toString());
        outState.putString("correo",tMail.getText().toString());
        outState.putString("telef",tTel.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        checkflag = savedInstanceState.getInt("banderacheck",checkflag);

        final TextView tName = (TextView) findViewById(R.id.tNombre);
        final TextView tMail = (TextView) findViewById(R.id.tCorreo);
        final TextView tTel = (TextView) findViewById(R.id.tTel);
        final TextView tsexo = (TextView) findViewById(R.id.tsexo);
        final TextView hobbies = (TextView) findViewById(R.id.thobbie);
        final TextView tciudad = (TextView) findViewById(R.id.tciudad);
        final TextView tnacimiento = (TextView) findViewById(R.id.tnacimiento);

        tsexo.setText(savedInstanceState.getString("sexo"));
        hobbies.setText(savedInstanceState.getString("hobb"));
        tciudad.setText(savedInstanceState.getString("ciudad"));
        tnacimiento.setText(savedInstanceState.getString("fecha"));

        tName.setText(savedInstanceState.getString("nomb"));
        tMail.setText(savedInstanceState.getString("correo"));
        tTel.setText(savedInstanceState.getString("telef"));

    }



}