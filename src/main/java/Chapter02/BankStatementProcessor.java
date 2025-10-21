package Chapter02;

import java.time.Month;
import java.util.List;

public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> transactions) {
        this.bankTransactions = transactions;
    }

    public double calculateTotalAmount() {
        double total = 0;
        for (BankTransaction transaction : bankTransactions) {
            total += transaction.getAmount();
        }

        return total;
    }

    public double calculateTotalInMonth(Month month) {
        double total = 0;
        for (BankTransaction transaction : bankTransactions) {
            if(transaction.getDate().getMonth() == month) {
                total += transaction.getAmount();
            }
        }

        return total;
    }

    public double calculateTotalForCategory (String category) {
        double total = 0;
        for (BankTransaction transaction : bankTransactions) {
            if(transaction.getDescription().equals(category)) {
                total += transaction.getAmount();
            }
        }

        return total;
    }

}
