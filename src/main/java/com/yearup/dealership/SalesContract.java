package com.yearup.dealership;

public class SalesContract extends Contract {
    private double salesTax;
    private double recordingFee;
    private double processingFee;

    private boolean financeOption;

    public SalesContract(String date, String name, String email, Vehicle vehicle, double totalPrice, double monthlyPayment, double recordingFee,
                         double processingFee, boolean financeOption) {
        super(date, name, email, vehicle);
        this.salesTax = 0.05;
        this.recordingFee = 100;
        this.processingFee = processingFee; //add an if statement to do the calculation
        this.financeOption = financeOption;
    }

    public double getProcessingFee() {
        if (getVehicle().getPrice() < 10000) {
            processingFee = 295;
        } else {
            processingFee = 495;
        }
        return processingFee;

    }


    @Override
    public double getTotalPrice() {
        return getVehicle().getPrice() + salesTax + recordingFee + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        int numberOfPayments = 0;
        double interestRate = 0;
        if (financeOption) {
            if (getVehicle().getPrice() >= 10000) {
                numberOfPayments = 48;
                interestRate = 4.25 / 1200;
            } else {
                numberOfPayments = 24;
                interestRate = 5.25 / 1200;
            }

            double monthlyPayment = getTotalPrice() * (interestRate * Math.pow(1 + interestRate, numberOfPayments)) / (Math.pow(1 + interestRate, numberOfPayments) - 1);
            monthlyPayment = Math.round(monthlyPayment * 100);
            monthlyPayment /= 100;
            return monthlyPayment;
        } else {
            return 0.0;
        }
    }

    public double getSalesTax() {

        return salesTax;
    }

    public void setSalesTax(double salesTax) {

        this.salesTax = salesTax;
    }

    public double getRecordingFee() {

        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {

        this.recordingFee = recordingFee;
    }

    public void setProcessingFee(double processingFee) {

        this.processingFee = processingFee;
    }

    public boolean isFinanceOption() {

        return financeOption;
    }

    public void setFinanceOption(boolean financeOption) {

        this.financeOption = financeOption;
    }
}
