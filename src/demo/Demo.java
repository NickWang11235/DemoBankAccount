package demo;

public class Demo {

    public static void main(String[] args) {
        
        BankAccount bob = new BankAccount("Bob");
        BankAccount tim = new BankAccount("Tim");
        
        bob.deposite(5000);
        bob.withdraw(200);
        tim.deposite(1000);
        bob.deposite(100,tim);
        bob.withdraw(200,tim);
        System.out.println(bob);
        System.out.println(bob.showTransacions());
        System.out.println(tim);
        System.out.println(tim.showTransacions());
        
        
    }
    
}
