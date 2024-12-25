package Strategy;

class CreditCard implements PaymentStrategy{
    public void pay(float amount){
        System.out.println("pay by CreditCard with amount: " + amount);
    }
}

class PayPal implements PaymentStrategy {
    public void pay(float amount){
        System.out.println("pay by PayPal with amount: " + amount);
    }
}

class Banktransfer implements PaymentStrategy {
    public void pay(float amount){
        System.out.println("pay by Banktransfer with amount: " + amount);
    }
}

class PaymentService{
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    
    public void order(float amount){
        paymentStrategy.pay(amount);
    }
}

class run{
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        
        paymentService.setPaymentStrategy(new CreditCard());
        paymentService.order(40);
    }
}
