package edu.qc.seclass.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalculatorActivity extends AppCompatActivity {

    EditText checkAmountValue,partySizeValue;
    TextView fifteenPercentTipValue,twentyPercentTipValue,twentyfivePercentTipValue,fifteenPercentTotalValue,twentyPercentTotalValue,twentyfivePercentTotalValue;
    Button buttonCompute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        //hooks
        checkAmountValue = findViewById(R.id.checkAmountValue);
        partySizeValue = findViewById(R.id.partySizeValue);
        fifteenPercentTipValue = findViewById(R.id.fifteenPercentTipValue);
        twentyPercentTipValue = findViewById(R.id.twentyPercentTipValue);
        twentyfivePercentTipValue = findViewById(R.id.twentyfivePercentTipValue);
        fifteenPercentTotalValue = findViewById(R.id.fifteenPercentTotalValue);
        twentyPercentTotalValue = findViewById(R.id.twentyPercentTotalValue);
        twentyfivePercentTotalValue = findViewById(R.id.twentyfivePercentTotalValue);
        buttonCompute = findViewById(R.id.buttonCompute);

        buttonCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkAmountValue.getText().toString().isEmpty() && partySizeValue.getText().toString().isEmpty()){
                    Toast.makeText(TipCalculatorActivity.this, "Empty or incorrect value(s)!", Toast.LENGTH_SHORT).show();
                }else {
                    int checkAmount = Integer.parseInt(checkAmountValue.getText().toString()); // get the value from checkAmountValue and parsing it to an Integer
                    int partySize = Integer.parseInt(partySizeValue.getText().toString()); // get the value from partySizeValue and parsing it to an Integer


                    double tipPerPerson15 =(checkAmount*(15/100.0f)) / partySize;       // (checkAmount*(15/100.0f)) is the 15 % of the checkAmount and (checkAmount*(15/100.0f)) / partySize 15% tip per person
                    fifteenPercentTipValue.setText(String.valueOf(Math.round(tipPerPerson15)));

                    double tipPerPerson20 =(checkAmount*(20/100.0f)) / partySize;       // (checkAmount*(20/100.0f)) is the 20 % of the checkAmount and (checkAmount*(20/100.0f)) / partySize 20% tip per person
                    twentyPercentTipValue.setText(String.valueOf(Math.round(tipPerPerson20)));

                    double tipPerPerson25 =(checkAmount*(25/100.0f)) / partySize;       // (checkAmount*(25/100.0f)) is the 25 % of the checkAmount and (checkAmount*(25/100.0f)) / partySize 25% tip per person
                    twentyfivePercentTipValue.setText(String.valueOf(Math.round(tipPerPerson25)));

                    double totalPerPerson15 =((checkAmount*(15/100.0f)) + checkAmount)/ partySize;       // ((checkAmount*(15/100.0f)) + checkAmount)/ partySize 15% total per person
                    fifteenPercentTotalValue.setText(String.valueOf(Math.round(totalPerPerson15)));

                    double totalPerPerson20 =((checkAmount*(20/100.0f)) + checkAmount) / partySize;       // ((checkAmount*(20/100.0f)) + checkAmount)/ partySize 20% total per person
                    twentyPercentTotalValue.setText(String.valueOf(Math.round(totalPerPerson20)));

                    double totalPerPerson25 =((checkAmount*(25/100.0f)) + checkAmount)/ partySize;       // ((checkAmount*(25/100.0f)) + checkAmount)/ partySize 25% total per person
                    twentyfivePercentTotalValue.setText(String.valueOf(Math.round(totalPerPerson25)));

                }


            }
        });

    }
}