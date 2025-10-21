package Chapter03;

import java.time.Month;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> transactions) {
        this.bankTransactions = transactions;
    }

    public SummaryStatistics summarizeTransactions() {
        DoubleSummaryStatistics summary = bankTransactions.stream()
                .mapToDouble(BankTransaction::getAmount)
                .summaryStatistics();

        return new SummaryStatistics(summary.getSum(), summary.getMax(), summary.getMin(), summary.getAverage());
    }

    public List<BankTransaction> findTransactionsGreaterThanEqual(final int amount) {
        return findTransactions(bankTransaction -> bankTransaction.getAmount() >= amount);
    }

    public List<BankTransaction> findTransactions(BankTransactionFilter bankTransactionFilter) {
        List<BankTransaction> result = new ArrayList<>();
        for (BankTransaction bankTransaction : bankTransactions) {
            if(bankTransactionFilter.test(bankTransaction)) {
                result.add(bankTransaction);
            }
        }
        
        return result;
    }

}
