import java.util.Scanner;

class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    // no sync - risky!!!! unsafe
    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " trying to withdraw " + amount + ", Current Balance: " + balance);
        if (balance >= amount) {
            // simulate time delay for context switching
            try {
                Thread.sleep(10); // race condition test
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ", New Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " failed to withdraw " + amount + ", Insufficient funds. Balance: " + balance);
        }
    }

    public int getBalance() {
        return balance;
    }
}


// we extend the class to have the synchronized method
// organised
class SynchronizedBankAccount extends BankAccount {
    public SynchronizedBankAccount(int initialBalance) {
        super(initialBalance);
    }

    @Override
    public synchronized void withdraw(int amount) {
        super.withdraw(amount);
    }
}

// now with runnable
class WithdrawTask implements Runnable {
    private BankAccount account;
    private int amountToWithdraw;

    public WithdrawTask(BankAccount account, int amountToWithdraw) {
        this.account = account;
        this.amountToWithdraw = amountToWithdraw;
    }

    @Override
    public void run() {
        account.withdraw(amountToWithdraw);
    }
}

public class BankMultiThreads {
    // ANSI color codes
    private static final String RESET = "\033[0m";
    private static final String BOLD = "\033[1m";
    private static final String BLUE = "\033[1;34m";
    private static final String GREEN = "\033[1;32m";
    private static final String YELLOW = "\033[1;33m";
    private static final String RED = "\033[1;31m";
    
    // UI elements
    private static final String WARNING = RED + "⚠ ";
    private static final String CHECK = GREEN + "✓ ";
    private static final String BULLET = YELLOW;

    // for aesthetic purposes
    private static void clearScreen() {
        try {
            // we use processbuilder cuz its easy to use
            // on unix we use a special escape sequence and flush the output to ensure consistency
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // fallback: print newlines
            // untested, os coded is Ubuntu 22.04
            for (int i = 0; i < 50; i++) System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            clearScreen();
            System.out.println("\n" + BLUE + "Welcome to the Bank Threading Demo" + RESET);
            System.out.println(BOLD + "Select an option:" + RESET);
            System.out.println(BULLET + "1." + RESET + " Run WITHOUT synchronization");
            System.out.println(BULLET + "2." + RESET + " Run WITH synchronization");
            System.out.println(BULLET + "3." + RESET + " Exit");
            System.out.println("\n" + BLUE + "===== by xX_zavocc_Xx =====" + RESET);
            System.out.print(BOLD + "Enter your choice: " + RESET);
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    clearScreen();
                    System.out.println(WARNING + "WARNING: Running without synchronization" + RESET);
                    BankAccount account = new BankAccount(100);
                    System.out.println(YELLOW + "Initial Balance: " + RESET + account.getBalance());
                    WithdrawTask task1 = new WithdrawTask(account, 75);
                    WithdrawTask task2 = new WithdrawTask(account, 75);
                    Thread thread1 = new Thread(task1, "User-1");
                    Thread thread2 = new Thread(task2, "User-2");
                    thread1.start();
                    thread2.start();
                    try {
                        thread1.join();
                        thread2.join();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.err.println("Main thread interrupted");
                    }
                    System.out.println(RED + "Final Balance (without synchronization): " + RESET + account.getBalance());
                    System.out.println("\n" + YELLOW + "Note:" + RESET + " Without synchronization, the balance might become negative or incorrect.");
                    System.out.print("\n" + BOLD + "Press Enter to return to menu..." + RESET);
                    scanner.nextLine();
                    clearScreen();
                    break;
                case "2":
                    clearScreen();
                    System.out.println(CHECK + "Running with synchronization" + RESET);
                    SynchronizedBankAccount syncAccount = new SynchronizedBankAccount(100);
                    System.out.println(YELLOW + "Initial Balance: " + RESET + syncAccount.getBalance());
                    WithdrawTask syncTask1 = new WithdrawTask(syncAccount, 75);
                    WithdrawTask syncTask2 = new WithdrawTask(syncAccount, 75);
                    Thread syncThread1 = new Thread(syncTask1, "Sync-User-1");
                    Thread syncThread2 = new Thread(syncTask2, "Sync-User-2");
                    syncThread1.start();
                    syncThread2.start();
                    try {
                        syncThread1.join();
                        syncThread2.join();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.err.println("Main thread interrupted");
                    }
                    System.out.println(GREEN + "Final Balance (with synchronization): " + RESET + syncAccount.getBalance());
                    System.out.println(YELLOW + "Note:" + RESET + " With synchronization, only one user should successfully withdraw.");
                    System.out.print("\n" + BOLD + "Press Enter to return to menu..." + RESET);
                    scanner.nextLine();
                    clearScreen();
                    break;
                case "3":
                    System.out.println(BLUE + "Exiting..." + RESET);
                    scanner.close();
                    return;
                default:
                    System.out.println(RED + "Invalid choice. Please try again." + RESET);
                    System.out.print("\nPress Enter to continue...");
                    scanner.nextLine();
                    clearScreen();
                    break;
            }
        }
    }
}