
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package campus.wallet.transfer;

/**
 *
 * @author Zhel
 */
public class CampusWalletTransfer {

    private String studentName;
    private double balance;

    // Constructor with an initial balance
    public CampusWalletTransfer(String studentName, double balance) {
        this.studentName = studentName;
        this.balance = (balance >= 0) ? balance : 0;
    }

    // Constructor with a default balance of zero
    public CampusWalletTransfer(String studentName) {
        this(studentName, 0);
    }

    // Get the current balance
    public double getBalance() {
        return balance;
    }

    // Add money to the wallet
    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }

        balance += amount;
        return true;
    }

    // Transfer money to another wallet
    public boolean transferTo(CampusWalletTransfer recipient, double amount) {

        if (recipient == null || recipient == this || amount <= 0 || amount > balance) {
            return false;
        }

        balance -= amount;
        recipient.balance += amount;

        return true;
    }

    public static void main(String[] args) {

        CampusWalletTransfer aly = new CampusWalletTransfer("Aly", 100);
        CampusWalletTransfer ben = new CampusWalletTransfer("Ben");

        System.out.println("Aly: " + aly.getBalance() + ", Ben: " + ben.getBalance());

        boolean step2 = aly.transferTo(ben, 35);
        System.out.println(step2 + "; Aly: " + aly.getBalance() + ", Ben: " + ben.getBalance());

        boolean step3 = aly.transferTo(ben, 70);
        System.out.println(step3 + "; Aly: " + aly.getBalance() + ", Ben: " + ben.getBalance());

        boolean step4 = aly.transferTo(aly, 10);
        System.out.println(step4 + "; Aly: " + aly.getBalance() + ", Ben: " + ben.getBalance());

        boolean step5 = ben.deposit(15);
        System.out.println(step5 + "; Aly: " + aly.getBalance() + ", Ben: " + ben.getBalance());

        boolean step6 = aly.transferTo(ben, 65);
        System.out.println(step6 + "; Aly: " + aly.getBalance() + ", Ben: " + ben.getBalance());

        boolean step7 = ben.transferTo(aly, 0);
        System.out.println(step7 + "; Aly: " + aly.getBalance() + ", Ben: " + ben.getBalance());

        boolean step8 = ben.transferTo(null, 20);
        System.out.println(step8 + "; Aly: " + aly.getBalance() + ", Ben: " + ben.getBalance());
    }
}
