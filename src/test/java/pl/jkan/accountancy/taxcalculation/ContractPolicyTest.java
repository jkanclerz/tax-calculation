package pl.jkan.accountancy.taxcalculation;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;

import static org.hamcrest.CoreMatchers.*;

public class ContractPolicyTest {
    private static final double net_1 = 1820.00;
    private static final double gross_1 = 2000.00;

    private static final double net_2 = 4000.00;
    private static final double gross_2 = 4396.00;

    @Test
    public void calculateWageFromProvidedMoneyValue() {
        ContractPolicy contractPolicy = new ContractPolicy();
        Wage wage = contractPolicy.calculateByNet(net_1);
        Assert.assertNotNull(wage);
    }

    @Test
    public void calculatedWageMustMatchInputValue() {
        ContractPolicy contractPolicy = new ContractPolicy();
        Wage wage = contractPolicy.calculateByNet(net_1);
        Assert.assertTrue("Cash must match",net_1 == wage.getNet());
    }

    @Test
    @Ignore
    public void calculatedWageMustContainValidGrossValue() {
        ContractPolicy contractPolicy = new ContractPolicy();
        Wage wage = contractPolicy.calculateByNet(net_1);
        Assert.assertThat(
                wage.getGross(),
                equalTo(gross_1)
        );
    }

    @Test
    public void calculatedWageMustContainValidNetValue() {
        ContractPolicy contractPolicy = new ContractPolicy();
        Wage wage = contractPolicy.calculateByGross(gross_1);
        Assert.assertThat(
                wage.getNet(),
                equalTo(net_1)
        );
    }


    @Test
    @Ignore
    public void calculatedWageMustContainValidGrossValue2() {
        ContractPolicy contractPolicy = new ContractPolicy();
        Wage wage = contractPolicy.calculateByNet(net_2);
        Assert.assertThat(
                wage.getGross(),
                equalTo(gross_2)
        );
    }

    @Test
    public void calculatedWageMustContainValidNetValue2() {
        ContractPolicy contractPolicy = new ContractPolicy();
        Wage wage = contractPolicy.calculateByGross(gross_2);
        Assert.assertThat(
                wage.getNet(),
                equalTo(net_2)
        );
    }
}
