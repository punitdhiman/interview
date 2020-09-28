package patterns.decorator;

public class Client {

    public static void main(String[] args) {
        PaymentCalculator paymentCalculator = new PaymentCalculatorImpl();
        System.out.println(paymentCalculator.calculate());
        paymentCalculator = new LocalGSTDecorator(paymentCalculator);
        System.out.println(paymentCalculator.calculate());
        paymentCalculator = new CentralGSTDecorator(paymentCalculator);
        System.out.println(paymentCalculator.calculate());
    }
}
