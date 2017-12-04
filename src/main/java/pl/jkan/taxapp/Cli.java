package pl.jkan.taxapp;

import pl.jkan.accountancy.Accountant;
import pl.jkan.accountancy.NotSupportedMethodException;
import pl.jkan.accountancy.taxcalculation.ContractPolicy;
import pl.jkan.accountancy.taxcalculation.Wage;

public class Cli {
    public static void main(String args[]) {
        String type = args[0];
        String inputValue = args[1];
        String amount = args[2];

        Accountant accountant = new Accountant();
        accountant.addMethod("uod", new ContractPolicy());

        if (inputValue.equals("brutto")) {
            try {
                Wage wage = accountant.calculateByGross(type, Double.parseDouble(amount));
                System.out.println(String.format("Contract type: %s", inputValue));
                System.out.println(String.format("Salary: %s", amount));
                System.out.println(String.format("Netto: %s | Brutto: %s", wage.getNet(), wage.getGross()));
            } catch (NotSupportedMethodException e) {
                e.printStackTrace();
            }
        }
    }
}
