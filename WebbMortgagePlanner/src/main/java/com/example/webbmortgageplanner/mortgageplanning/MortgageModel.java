package com.example.webbmortgageplanner.mortgageplanning;

public class MortgageModel {

    private final double b; //Interest on a monthly basis

    private final double u; //Total loan

    private final double p; //number of payments

    /**
     * Constructor.
     * The constructor uses static methods get the monthly interest and number of payments.
     * @param yearlyInterest given by file.
     * @param totalLoan given by file.
     * @param years given by file
     * */

    public MortgageModel(double yearlyInterest, double totalLoan, double years){

        this.b = MortgageModel.calculateMonthlyInterestrate(yearlyInterest);
        this.u = totalLoan;
        this.p = MortgageModel.calculateNumberOfPayments(years);
    }

    /**
     *  The interest give for each customer found in the file, this is a yearly interest.
     *  Method to calculate the monthly interest.
     *  @param yearlyInterest, the yearly interest given by the attached file and read into a Customer object.
     *  @return the monthly interest rate
     * */

    public static double calculateMonthlyInterestrate(double yearlyInterest){

        //Convert yearly rate from percent to decimal
        yearlyInterest = yearlyInterest/100;
        return yearlyInterest/12;

    }

    /**
     * Method to calculate the number of payments.
     * @param years, amount of years the customer wants to pay off the loan, given by attached file.
     * @return the number of payments, i.e. amount of months
     * */

    public static double calculateNumberOfPayments(double years){
        return years*12;
    }




    /**
     * Method to calculate power of.
     * @param base, value of the base.
     * @param exponent, value of the exponent.
     * @return the power of
     * @throws IllegalArgumentException, if the exponent < 0
     *
     * */

    public static double calculatePowerOf(double base, double exponent){

        double result;
        if(exponent > -1){

            result= 1;
            while(exponent != 0){

                result=result*base;
                exponent--;
            }
        }else{
            throw new IllegalArgumentException("Negative exponent!");
        }

        return result;
    }


    /**
     * Method to calculate the mortgage formula
     * @return the fixed monthly payment
     *
     * */

    public double calculateMortgageFormula(){

        return u*(b*(MortgageModel.calculatePowerOf(1+b, p)))/((MortgageModel.calculatePowerOf(1+b, p))-1);
    }
}
