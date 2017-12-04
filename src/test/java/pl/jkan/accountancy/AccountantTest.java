package pl.jkan.accountancy;

import org.junit.Test;
import org.junit.Assert;
import pl.jkan.accountancy.taxcalculation.GrayEconomyPolicy;
import pl.jkan.accountancy.taxcalculation.Wage;

import static org.hamcrest.CoreMatchers.*;

public class AccountantTest {

    @Test
    public void ItIsPossibleToAddCalculationMethodsForAccountant() {
        Accountant accountant = new Accountant();
        accountant.addMethod("uod", new GrayEconomyPolicy());
    }

    @Test
    public void accountantCantCalculateWhenMethodNotKnown() {
        Accountant accountant = new Accountant();

        try {
            accountant.calculateByGross("uod", 100);
        } catch (NotSupportedMethodException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void calculateWageForPresentMethod() {
        Accountant accountant = new Accountant();
        accountant.addMethod("uod", new GrayEconomyPolicy());

        try {
            Wage wage = accountant.calculateByGross("uod", 10000.00);
            Assert.assertThat(
                    wage.getGross(),
                    equalTo(10000.00)
            );
            Assert.assertThat(
                    wage.getNet(),
                    equalTo(10000.00)
            );
        } catch (NotSupportedMethodException e) {
            e.printStackTrace();
        }
    }
}

