
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package print.accoutn;

/**
 *
 * @author Zhel
 */
public class PrintAccoutn {

    private String studentName;
    private int credits;

    // Constructor: Sets the student's name and starting credits.
    // Negative starting credits will automatically become zero.
    public PrintAccoutn(String studentName, int credits) {
        this.studentName = studentName;

        if (credits < 0) {
            this.credits = 0;
        } else {
            this.credits = credits;
        }
    }

    // Adds credits if the amount is positive.
    public boolean addCredits(int amount) {
        if (amount <= 0) {
            return false;
        }

        this.credits += amount;
        return true;
    }

    // Deducts credits if the page count is valid and affordable.
    public boolean printPages(int pages) {
        if (pages <= 0 || pages > this.credits) {
            return false;
        }

        this.credits -= pages;
        return true;
    }

    // Returns the current credits.
    public int getCredits() {
        return this.credits;
    }

    public static void main(String[] args) {

        // Create two independent printing accounts.
        PrintAccoutn mia = new PrintAccoutn("Mia", 10);
        PrintAccoutn luis = new PrintAccoutn("Luis", -4);

        // Display starting credits.
        System.out.println("Mia: " + mia.getCredits());
        System.out.println("Luis: " + luis.getCredits());

        // Mia prints 4 pages.
        System.out.println("Print 4 pages: " + mia.printPages(4));
        System.out.println("Mia: " + mia.getCredits());

        // Mia tries to print more pages than her credits.
        System.out.println("Print 7 pages: " + mia.printPages(7));
        System.out.println("Mia: " + mia.getCredits());

        // Mia tries to add negative credits.
        System.out.println("Add -3 credits: " + mia.addCredits(-3));
        System.out.println("Mia: " + mia.getCredits());

        // Mia adds 4 credits.
        System.out.println("Add 4 credits: " + mia.addCredits(4));

        // Display final credits.
        System.out.println("Mia: " + mia.getCredits());
        System.out.println("Luis: " + luis.getCredits());
    }
}

/*
 * Activity 1 - AI Use Note
 *
 * Prompt used:
 * "What conditions should I check before deducting printing credits?"
 *
 * What I accepted:
 * I accepted the suggestion to check whether the page count is positive
 * and whether the account has enough credits before deducting.
 *
 * What I rejected:
 * I did not need to add unnecessary features outside the instructions.
 *
 * How I checked it:
 * I ran the program using the given test cases and checked if the
 * results matched the expected output.
 */
