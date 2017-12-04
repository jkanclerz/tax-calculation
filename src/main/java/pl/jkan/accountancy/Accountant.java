package pl.jkan.accountancy;

import pl.jkan.accountancy.taxcalculation.Wage;
import pl.jkan.accountancy.taxcalculation.WageCalculationPolicy;

import java.util.HashMap;

public class Accountant {

    private HashMap<String, WageCalculationPolicy> methods;

    public Accountant() {
        this.methods = new HashMap<String, WageCalculationPolicy>();
    }

    public void addMethod(String key, WageCalculationPolicy calculationPolicy) {
        methods.put(key, calculationPolicy);
    }

    public Wage calculateByGross(String contractType, double money) throws NotSupportedMethodException {

        if (!methods.containsKey(contractType)) {
            throw new NotSupportedMethodException();
        }

        return methods.get(contractType).calculateByGross(money);
    }
}
