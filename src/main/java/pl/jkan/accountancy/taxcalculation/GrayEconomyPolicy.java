package pl.jkan.accountancy.taxcalculation;

public class GrayEconomyPolicy implements WageCalculationPolicy {

    public Wage calculateByNet(double money) {

        return new Wage(money, money);
    }

    public Wage calculateByGross(double money) {

        return new Wage(money, money);
    }
}
