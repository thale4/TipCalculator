package com.example.scobb.tipcalculator;

import static java.lang.Float.parseFloat;

/**
 * Created by thale4 on 9/2/2017.
 */

public class TipCalculatorModel
{
    public float calculateTip(String billInput, String tipPercentInput)
    {
        float billAmount = 0;
        float tipPercent = 0;

        billAmount = parseFloat(billInput);
        tipPercent = parseFloat(tipPercentInput);

        float tip = billAmount * (tipPercent / 100);

        return tip;
    }

    public float calculateTotal(String billInput, float tip)
    {
        float total = tip + parseFloat(billInput);
        return total;
    }
}

