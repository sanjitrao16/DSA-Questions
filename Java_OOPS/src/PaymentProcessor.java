public class PaymentProcessor {
    protected String gatewayName;
    protected double processingFee;

    public PaymentProcessor() {
        System.out.println("Default Constructor");
    }
    public PaymentProcessor(String gatewayName,double processingFee) {
        this.gatewayName = gatewayName;
        this.processingFee = processingFee;

        System.out.println("Gateway Initialized");
    }

    public void processPayment(double amount) {
        double fee = amount * (processingFee/100);
        System.out.println("Processing Fee for the amount "+amount+" is "+String.format("%.2f",fee));
    }

    public static void main(String[] args) {
        RazorPayProcessor payment = new RazorPayProcessor("gtyr53i9%");
        payment.processPayment(10000);
    }
}

class RazorPayProcessor extends PaymentProcessor {
    private String apiKey;

    public RazorPayProcessor(String apiKey) {
        super("RazorPay",1.4);
        this.apiKey = apiKey;
        System.out.println("API Key verified");
    }

    public void processPayment(double amount) {
        super.processPayment(amount);
        System.out.println("Payment done through RazorPay service");
    }
}
