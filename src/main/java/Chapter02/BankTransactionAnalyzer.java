package Chapter02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class BankTransactionAnalyzer {
    private static final String RESOURCES = "src/main/resources/";

    public static void main(String... args) throws IOException {
        BankStatementCSVParser bankCSVParser = new BankStatementCSVParser();
        String fileName = "bank-data-simple.csv";
        Path path = Paths.get(RESOURCES + fileName);
        List<String> lines = Files.readAllLines(path);
        List<BankTransaction> transactions = bankCSVParser.parseLinesFromCSV(lines);

        System.out.println("The total amount for transactions is: " + calculateTotalAmount(transactions));
        System.out.print("Transactions in January: " + selectInMonth(transactions, Month.JANUARY));
    }

    public static double calculateTotalAmount(List<BankTransaction> transactions) {
        double total = 0d;
        for(BankTransaction transaction : transactions){
            total += transaction.getAmount();
        }

        return total;
    }

    public static List<BankTransaction> selectInMonth(List<BankTransaction> transactions, Month month) {
        List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();
        for(BankTransaction transaction : transactions) {
            if (transaction.getDate().getMonth() == month) {
                bankTransactionsInMonth.add(transaction);
            }
        }

        return bankTransactionsInMonth;
    }
}
