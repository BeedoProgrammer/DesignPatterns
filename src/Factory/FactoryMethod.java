package Factory;

public abstract class FactoryMethod {
    public void order(){
        Payment payment = CreatePaymentType();
        payment.processPayment();
    }
    
    public abstract Payment CreatePaymentType();
}

class CreditCardPayment implements Payment{
    @Override
    public void processPayment(){
        System.out.println("CreditCardPayment");
    }
}

class PayPalPayment implements Payment{
    @Override
    public void processPayment(){
        System.out.println("PayPalPayment");
    }
}

class GooglePayPayment implements Payment{
    @Override
    public void processPayment(){
        System.out.println("GooglePayPayment");
    }
}

class CreditCardFactory extends FactoryMethod{
    @Override
    public Payment CreatePaymentType(){
        return new CreditCardPayment();
    }
}

class PayPalFactory extends FactoryMethod{
    @Override
    public Payment CreatePaymentType(){
        return new PayPalPayment();
    }
}

class GooglePayFactory extends FactoryMethod{
    @Override
    public Payment CreatePaymentType(){
        return new GooglePayPayment();
    }
}

class main{
    public static void main(String[] args) {
        FactoryMethod credit = new CreditCardFactory();
        credit.order();
        
        FactoryMethod google = new GooglePayFactory();
        google.order();
        
        FactoryMethod paypal = new PayPalFactory();
        paypal.order();
    }
}
