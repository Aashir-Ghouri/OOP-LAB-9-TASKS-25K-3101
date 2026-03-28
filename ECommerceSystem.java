interface OnlinePayment {
    void pay(int amount);
}

interface CashPayment {
    void pay(int amount);
}

abstract class Order {
    String orderID;
    int amount;

    public Order(String PorderID, int Pamount) {
        this.orderID = PorderID;
        this.amount = Pamount;
    }

    abstract void processOrder();

    class Invoice {
        void generate() {
            System.out.println("--- INVOICE GENERATED ---");
            System.out.println("Order ID: " + orderID);
            System.out.println("Total Amount: " + amount);
            System.out.println("Status: PAID");
        }
    }
}

// 4. Concrete Order Implementation
class WebOrder extends Order implements OnlinePayment, CashPayment {

    private Invoice invoice;

    public WebOrder(String orderID, int amount) {
        super(orderID, amount);
        this.invoice = new Invoice();
    }

    @Override
    void processOrder() {
        System.out.println("Processing Web Order for #" + orderID);
    }

    @Override
    public void pay(int amount) {
        System.out.println("Payment of " + amount + " received for Order " + orderID);
        invoice.generate();
    }
}

public class ECommerceSystem {
    public static void main(String[] args) {
        WebOrder order = new WebOrder("ARA-1120", 4500);

        order.processOrder();
        order.pay(4500);
    }
}
