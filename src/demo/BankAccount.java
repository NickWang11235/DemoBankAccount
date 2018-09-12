package demo;

import demo.Util.Date;
import java.util.ArrayList;
import java.util.Collections;


public class BankAccount{
    
    private Date date;
    
    private final String name;
    private double balance;
    private Transactions[] transactions;
    private int tCount;
    
    {
        date = new Date(2018, Date.Month.SEP, 7);
    }
    
    public BankAccount(String name){
        this.name = name;
        tCount = 0;
        transactions = new Transactions[1];
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public Transactions[] getTransactions() {
        return transactions;
    }
    
    public boolean deposite(double amount){
        balance += amount;
        add(new Transactions(null, this, amount, "Deposite"));
        return true;
    }

    public boolean deposite(double amount, BankAccount from){
        if(from.balance >= amount){
            from.balance -= amount;
            balance += amount;
            add(new Transactions(from, this, amount, "Deposite"));
            from.add(new Transactions(from, this, amount, "Withdraw"));
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount){
        balance -= (balance >= amount) ? amount : 0;
        add(new Transactions(this, null, amount, "withdraw"));
        return balance >= amount;
    }
    
    public boolean withdraw(double amount, BankAccount to){
        balance -= (balance >= amount) ? amount : 0;
        to.balance += (balance >= amount) ? amount : 0;
        if(balance >= amount){
            add(new Transactions(this, to, amount, "withdraw"));
            to.add(new Transactions(this, to, amount, "Deposite"));
        }
        return balance >= amount;
    }
    
    
    private boolean add(Transactions... t){
        if(tCount + t.length <= transactions.length){
            for(Transactions act : t){
                transactions[tCount] = act;
                tCount++;
            }
            return true;
        }else{
            if(tCount + t.length > transactions.length*2){
                Transactions[] temp = new Transactions[(tCount + t.length)*2];
                int i = 0;
                for(Transactions act : transactions){
                    temp[i++] = act;
                }
                for(Transactions act : t){
                    temp[i++] = act;
                }
                transactions = temp;
                tCount += t.length;
                return true;
            }else{
                Transactions[] temp = new Transactions[transactions.length*2];
                int i = 0;
                for(Transactions act : transactions){
                    temp[i] = act;
                    i += 1;
                }
                for(Transactions act : t){
                    temp[i] = act;
                    i += 1;
                }
                transactions = temp;
                tCount += t.length;
                return true;
            }            
        }
    }
    
    public static ArrayList<BankAccount> sort(ArrayList<BankAccount> ba){
        Collections.sort(ba, (o1, o2) -> (int)(o1.balance-o2.balance)*100 + o1.date.compareTo(o2.date)*10 + o1.name.compareTo(o2.name) );
        return ba;
    }
    
    @Override
    public String toString(){
        return "Name: " + name + "; Balance: " + balance + "; Past transactions: " + tCount;
    }
    
    public String showTransacions(){
        String str = "[";
        for(Transactions t : transactions){
            if(t != null){
                str += t.toString();
                str += ", ";
            }
        }
        str += "]";
        return str;
    }
    
}
