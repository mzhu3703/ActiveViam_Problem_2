package com.company;
import java.util.*;
import javax.sound.sampled.Port;

public class Main {





    public static double varPortfolioCalc(double confidence, List<Double> p1, List<Double> p2, List<Double> p3){
        List<Double> portfolioGain = new ArrayList();
        for(int i = 0; i < p1.size(); i++){
            double sum = p1.get(i) + p2.get(i) + p3.get(i);
            portfolioGain.add(sum);
        }

        double check = percentile(portfolioGain, confidence);

        return check;
    }

    //calculates percentile using nearest rank method
    public static double percentile(List<Double> values, double percentile) {
        Collections.sort(values);
        if(percentile == 0){
            return values.get(values.size()-1);
        }
        int index = (int) Math.ceil((percentile / 100) * values.size());
        return values.get(index - 1);
    }



    public static void main(String[] args) {
        //retrieved stock historical values from random companies from yahoo finance
        double[] test = {151, 150, 149.99, 147.87, 147.92, 150.81, 150.44, 151.28, 150.96, 151.49, 150.02,
                         148.96, 149.80, 152.57, 148.85, 149.32, 148.64, 148.69, 149.48, 149.26, 148.76};
        Stock s1 = new Stock();
        s1.setAmountInvested(100);
        s1.setHistorical_values(test);
        List<Double> p1 = s1.profitGain(s1.getHistorical_values());

        double[] test2 = {137.41, 136.55, 140.96, 141.83, 139.58, 142.19, 139.89, 137.25, 138.52, 139.35, 139.61, 136.94,
                            140.72, 136.92, 137.46, 138.69, 137.72, 137.61, 139.36, 143.22, 144.72
        };
        Stock s2 = new Stock();
        s2.setAmountInvested(100);
        s2.setHistorical_values(test2);
        List<Double> p2 =  s2.profitGain(s2.getHistorical_values());

        double [] test3 = {272.94, 269.70, 268.42, 276.92, 275.58, 277.80, 276.97, 286.54, 287.51, 281.85, 279.70, 285.57,
                            283.39, 277.920, 277.11, 273.54, 274.19, 275.54, 275.67, 274.48, 276.39,
        };
        Stock s3 = new Stock();
        s3.setAmountInvested(200);
        s3.setHistorical_values(test3);
        List<Double> p3 = s3.profitGain(s3.getHistorical_values());

        try {
            System.out.println("Welcome");
            System.out.println("To quit at anytime please type \"Q\". Enter a confidence level:");
            Scanner scan = new Scanner(System.in);
            while (scan.hasNext()) {
                if (scan.hasNextDouble()) {
                    double confidence = scan.nextDouble();
                    System.out.println("The VaR is " + varPortfolioCalc(100 - confidence, p1,p2,p3));
                    System.out.println("Please enter another confidence level");
                } else {
                    String input = scan.next();
                    if (input.equalsIgnoreCase("Q")){
                        System.out.println("Exiting");
                        break;
                    }else {
                        System.out.println("You did not enter a valid value. Please enter a number or \"Q\" to quit.");
                    }
                }

            }
        } catch (Exception e) {
            System.out.println("Exiting Program.");

        }




    }
}
