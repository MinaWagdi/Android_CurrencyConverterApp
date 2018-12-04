package com.example.minarafla.task1_currencyconverter;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private String tag = "MINAS_TAG";
    TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultView = (TextView) findViewById(R.id.textView6);

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Convert();
            }
        });
        try {
            if (savedInstanceState != null) {
                String retrievedresult = savedInstanceState.getString("resultViewGetValue");
                resultView.setText(retrievedresult);
            }
        }catch(Exception ex){
            Log.i(tag,"exception when trying to retrieve the saved State is "+ex.getClass());
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        try {
            outState.putString("resultViewGetValue", resultView.getText().toString());
        }catch (Exception ex){
            Log.i(tag,"exception when trying to save the state is "+ex.getClass());
        }


    }

    public void Convert(){

        Log.i(tag,"I have just entered the convert method");
        double result=0;
        try{
            EditText valueText = (EditText)findViewById(R.id.editText2);
            Double value = Double.parseDouble(valueText.getText().toString());

            Spinner fromSpinner = (Spinner) findViewById(R.id.spinner);
            String fromCurrency = fromSpinner.getSelectedItem().toString();

            Spinner toSpinner = (Spinner) findViewById(R.id.spinner3);
            String toCurrency = toSpinner.getSelectedItem().toString();

            //resultView.setText("" + result);

            if (fromCurrency.equalsIgnoreCase("EGP")) {
                if (toCurrency.equalsIgnoreCase("Dollars")) {
                    result = value * 17.6;
                    resultView.setText("" + result);
                } else {
                    Toast.makeText(getApplicationContext(),"The 2 currencies are the same",Toast.LENGTH_LONG).show();
                }
            } else {
                if (toCurrency.equalsIgnoreCase("EGP")) {
                    result = value / 17.6;
                    resultView.setText("" + result);
                } else {
                    Toast.makeText(getApplicationContext(),"The 2 currencies are the same",Toast.LENGTH_LONG).show();
                }

            }

        }
        catch (java.lang.NumberFormatException ex) {
            Log.i(tag,"exception is "+ex.getClass());
            Toast.makeText(getApplicationContext(),"Please Enter a value",Toast.LENGTH_LONG).show();
        }










    }
}
