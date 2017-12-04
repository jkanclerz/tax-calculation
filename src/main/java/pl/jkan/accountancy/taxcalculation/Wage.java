package pl.jkan.accountancy.taxcalculation;

public class Wage {
    private double net;
    private double gross;

    public Wage(double net, double gross) {
        this.net = net;
        this.gross = gross;
    }

    public double getNet() {
        return net;
    }

    public double getGross() {
        return gross;
    }
}
