// Samuel Cobb and Trevor Hale ("Pair-Programming")

package com.example.scobb.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.text.NumberFormat;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Float.parseFloat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View button = findViewById(R.id.CalculateButton);
        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                calculateBillTotal();
            }
        });
    }

    public void calculateBillTotal()
    {
        TextView billInputField = (TextView)findViewById(R.id.BillInput);
        TextView tipPercentInputField = (TextView)findViewById(R.id.TipPercentInput);

        TextView tipField = (TextView)findViewById(R.id.TipAmount);
        TextView totalBillField = (TextView)findViewById(R.id.TotalBillAmount);

        String BillInput = billInputField.getText().toString();
        String TipPercentInput = tipPercentInputField.getText().toString();

        try
        {
            NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();

            TipCalculatorModel tipCalculatorModel = new TipCalculatorModel();

            float tip = tipCalculatorModel.calculateTip(BillInput, TipPercentInput);
            float total = tipCalculatorModel.calculateTotal(BillInput, tip);

            String FormattedBill = moneyFormat.format(total);
            String FormattedTip = moneyFormat.format(tip);

            tipField.setText(FormattedTip);
            totalBillField.setText(FormattedBill);
        }
        catch(NumberFormatException e)
        {
            Toast.makeText(this, "Enter numbers for bill and tip percent.", Toast.LENGTH_SHORT).show();
            tipField.setText(null);
            totalBillField.setText(null);
        }
    }
}