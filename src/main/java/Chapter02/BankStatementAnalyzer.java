package Chapter02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {
    static final String RESOURCES = "src/main/resources/";

    public void analyze(String fileName, BankStatementParser bankParser) throws IOException {
        Path path = Paths.get(RESOURCES + fileName);
        List<String> lines = Files.readAllLines(path);
        List<BankTransaction> bankTransactions = bankParser.parseLinesFrom(lines);
        BankStatementProcessor bankProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankProcessor);
    }

    private static void collectSummary(BankStatementProcessor bankProcessor) {
        System.out.println("The total for all transactions is "
                + bankProcessor.calculateTotalAmount());
        System.out.println("The total for transactions in January is "
                + bankProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total for transactions in February is "
                + bankProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("The total salary received is "
                + bankProcessor.calculateTotalForCategory("Salary"));
    }
}
