package com.company;
import java.util.*;

public class Stock {

    int amountInvested;
    double[] historical_values;

    public int getAmountInvested() {
        return amountInvested;
    }

    public void setAmountInvested(int amountInvested) {
        this.amountInvested = amountInvested;
    }

    public double[] getHistorical_values() {
        return historical_values;
    }

    public void setHistorical_values(double[] historical_values) {
        this.historical_values = historical_values;
    }


    public List<Double> profitGain(double[] historical_values){
        List<Double> profit = new ArrayList();
        for(int i = 0; i < historical_values.length-1; i++){
            profit.add((Math.log(historical_values[i]/historical_values[i+1]) * 100) * amountInvested);
        }
        return profit;

    }

}
