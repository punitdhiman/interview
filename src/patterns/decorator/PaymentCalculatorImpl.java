package patterns.decorator;

import java.math.BigDecimal;

public class PaymentCalculatorImpl implements PaymentCalculator{
    @Override
    public BigDecimal calculate() {
        return new BigDecimal(1.0);
    }
}
