package com.example.ass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Arrays;

public class ZakatCalculate extends AppCompatActivity implements View.OnClickListener {

    EditText etWeight, etCurrent;
    RadioButton rbKeep, rbWear;
    RadioGroup radioGroup;
    float etType, outWeight, outCurrent, outValue, outZakatPay, outZakatTot;
    Button btnTotal, btnClear;
    TextView totValue, totZakatPay, totZakat;

    String Shared_pref = "sharedPrefs";
    String gold_weight = "etWeight";
    String gold_value = "etCurrent";
    private Bundle savedInstanceState;
    private RadioButton radioButtonMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakat_calculate);
        etWeight = (EditText) findViewById(R.id.weight);
        etCurrent = (EditText) findViewById(R.id.currentvalue);
        rbKeep = (RadioButton) findViewById(R.id.rbKeep);
        rbWear = (RadioButton) findViewById(R.id.rbWear);
        btnTotal = (Button) findViewById(R.id.btnTotal);
        btnClear = (Button) findViewById(R.id.btnClear);
        totValue = (TextView) findViewById(R.id.totalValue);
        totZakatPay = (TextView) findViewById(R.id.zakatpayable);
        totZakat = (TextView) findViewById(R.id.totalzakat);
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);

        boolean keepChecked = rbKeep.isChecked();
        boolean wearChecked = rbWear.isChecked();
        btnTotal.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }
    @Override
    public void onClick (View view){


        String etWeightEmpty=etWeight.getText().toString();
        String etCurrentEmpty=etCurrent.getText().toString();
        int choosetype=radioGroup.getCheckedRadioButtonId();
        radioButtonMessage=(RadioButton)findViewById(choosetype);

        if((etWeightEmpty.matches(""))){
            Toast.makeText(this,"Please enter Gold Weight (g) ",Toast.LENGTH_SHORT).show();
        }
        if((etCurrentEmpty.matches(""))){
            Toast.makeText(this,"Please enter Current Gold Value ",Toast.LENGTH_SHORT).show();
        }
        if(choosetype==-1){
            Toast.makeText(this,"Please choose type (KEEP/WEAR)",Toast.LENGTH_SHORT).show();
        }else{
            if(rbWear.isChecked()){

                String weight=etWeight.getText().toString();
                double etType=200;
                double outWeight=Double.parseDouble(etWeight.getText().toString());
                double outCurrent=Double.parseDouble(etCurrent.getText().toString());
                double outValue=outWeight*outCurrent;
                double outZakatPay=(outWeight-etType)*outCurrent;
                double e=outZakatPay*0.025;

                if((outWeight-etType)<=0){
                    //totPayable = 0, finalZakat = 0;
                    totValue.setText(String.format("Total Value of Gold = RM %.2f",outValue));
                    totZakatPay.setText(String.format("Total Zakat Payable = RM 0"));
                    totZakat.setText(String.format("Total Zakat = RM 0"));
                }else{
                    totValue.setText(String.format("Total Value of Gold = RM %.2f",outValue));
                    totZakatPay.setText(String.format("Total Zakat Payable = RM %.2f",outZakatPay));
                    totZakat.setText(String.format("Total Zakat = RM %.2f",outZakatTot));
                }
            }
                    /*String totValGold = String.valueOf(c);
                    String totPayable = String.valueOf(d);
                    String finalZakat = String.valueOf(e);*/

        }
        if(rbKeep.isChecked()){

            String weight=etWeight.getText().toString();
            double etType=200;
            double outWeight=Double.parseDouble(etWeight.getText().toString());
            double outCurrent=Double.parseDouble(etCurrent.getText().toString());
            double outValue=outWeight*outCurrent;
            double outZakatPay=(outWeight-etType)*outCurrent;
            double outZakatTot=(outZakatPay*0.025);

            if((outWeight-etType)<=0){
                //totPayable = 0, finalZakat = 0;
                totValue.setText(String.format("Total Value of Gold = RM %.2f",outValue));
                totZakatPay.setText(String.format("Total Zakat Payable : RM 0"));
                totZakat.setText(String.format("Total Zakat = RM 0"));
            }else{
                totValue.setText(String.format("Total Value of Gold = RM %.2f",outValue));
                totZakatPay.setText(String.format("Total Zakat Payable = RM %.2f",outZakatPay));
                totZakat.setText(String.format("Total Zakat = RM %.2f",outZakatTot));
            }
        }
        switch (view.getId()) {

            case R.id.btnTotal:
                break;

            case R.id.btnClear:
                Clear();
                radioGroup.clearCheck();
                break;
        }
    }




    public void findRadioButton(int checkId) {

        switch (checkId) {
            case R.id.rbKeep:
                break;
            case R.id.rbWear:
                break;
        }
    }


    public void checkButton(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();

        rbKeep = findViewById(radioId);
        rbWear = findViewById(radioId);

        Toast.makeText(this, "Gold Category : " + rbKeep.getText(),
                Toast.LENGTH_SHORT).show();

    }


    public void Clear() {

        etWeight.setText("");
        etCurrent.setText("");
        totValue.setText(" ");
        totZakatPay.setText("  ");
        totZakat.setText(" ");
    }



}

