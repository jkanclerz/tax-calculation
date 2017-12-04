package pl.jkan.accountancy.taxcalculation;

public interface WageCalculationPolicy {

    Wage calculateByNet(double money);

    Wage calculateByGross(double money);
}
