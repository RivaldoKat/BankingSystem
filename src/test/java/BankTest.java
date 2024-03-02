import org.example.Bank;

public class BankTest {
    private static Bank bank = new Bank();
    private static boolean isForeign;
    private static int acct = bank.newAccount(isForeign);

    public static void main(String... args){
        verifyBalance("initial amount", 0);
        bank.deposit(acct, 10);
        verifyBalance("after deposit", 0);
        verifyLoan("authorize bad loan", 22, false);
        verifyLoan("authorize good loan", 20, true);
    }

    private static void verifyBalance(String msg, int expectedVal){
        int balance = bank.getBalance(acct);
        boolean ok = (balance == expectedVal);
        String result = ok ? "Good! " : "Bad! ";
        System.out.println(msg + ": " + result);
    }
    private static void verifyLoan(String msg, int loanAmt, boolean expectedVal){
        boolean answer = bank.authorizeLoan(acct, loanAmt);
        boolean ok = (answer == expectedVal);
        String results = ok ? "Good! " : "Bad! ";
        System.out.println(msg + ": " + results);
    }
}
