package patterns.decorator;

import java.math.BigDecimal;

public class CentralGSTDecorator implements PaymentCalculator{
    final PaymentCalculator paymentCalculator;

    public CentralGSTDecorator(final PaymentCalculator paymentCalculator){
        this.paymentCalculator = paymentCalculator;

    }
    @Override
    public BigDecimal calculate() {
        BigDecimal price = paymentCalculator.calculate();
        return price.add(new BigDecimal("0.6"));
    }
}
