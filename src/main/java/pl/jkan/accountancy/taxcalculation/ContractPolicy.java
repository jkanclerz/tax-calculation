package pl.jkan.accountancy.taxcalculation;

import java.text.DecimalFormat;

public class ContractPolicy implements WageCalculationPolicy {

    private static final double COST = 0.50;
    private static final double TAX = 0.18;

    public Wage calculateByNet(double money) {
        return new Wage(money, 0);
    }

    public Wage calculateByGross(double money) {
        double incomeCost = calculateIncomeCost(money);
        double taxBase = calculateTaxBase(money, incomeCost);
        double tax = calculateTax(taxBase);
        double net = calculateNetValue(money, tax);
        double rounded = roundTo00Precision(net);

        return new Wage(rounded, money);
    }

    private double roundTo00Precision(double net) {
        return Math.floor(net);
    }

    private double calculateNetValue(double money, double tax) {
        return (money - tax);
    }

    private double calculateTax(double taxBase) {
        return taxBase * TAX;
    }

    private double calculateTaxBase(double money, double incomeCost) {
        return money - incomeCost;
    }

    private double calculateIncomeCost(double money) {
        return money * COST;
    }
}
