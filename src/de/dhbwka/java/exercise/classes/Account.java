package de.dhbwka.java.exercise.classes;

public class Account {
    
    private int id;
    private String name;
    private double balance;
    private double limit;

    public static void main(String[] args) {
        Account account = new Account(4711, "Donald Duck", 500, 1000);
        System.out.println(account);
        account.processDeposit(200);
        System.out.println(account);
        account.processPayment(400);
        System.out.println(account);
        account.processPayment(2000);
        System.out.println(account);
    }

    public Account(int id, String name){
        this(id, name, 0, 100);
    }
    public Account(int id, String name, double balance){
        this(id, name, balance, 100);
    }
    public Account(int id, String name, double balance, double limit){
        setId(id);
        setName(name);
        setBalance(balance);
        setLimit(limit);    
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getLimit() {
        return limit;
    }
    public void setLimit(double limit) {
        this.limit = limit;
    }

    public String toString(){
        return "Account number "+getId()+" ("+getName()+"), Balance: "+getBalance()+", Limit: "+getLimit();
    }
    public void processDeposit(double deposit){
        if(deposit>0){
            setBalance(getBalance()+deposit);
        }else{
            System.err.println("Keine Einzahlung von negativen Beträgen möglich!");
        }
    }
    public void processPayment(double payment){
        if(getBalance() - payment >= getLimit()*-1){
            setBalance(getBalance()-payment);
            System.err.println("Zahlung erfolgreich!");
        }else{
            System.err.println("Zahlung abgelehnt!");
        }
    }
}
