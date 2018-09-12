package demo;

public class Transactions {

    private final BankAccount from;
    private final BankAccount to;
    private final double amount;
    private final String type;

    public Transactions(BankAccount from, BankAccount to, double amount, String type) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.type = type;
    }

    public BankAccount getFrom() {
        return from;
    }

    public BankAccount getTo() {
        return to;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }
    
    @Override
    public String toString(){
        if(from == null){
            return type + " " + amount + " to " + to.getName();
        }
        if(to == null){
            return type + " " + amount + " from " + from.getName();
        }
        return type + " " + amount + " from " + from.getName() + " to " + to.getName();
    }

}
