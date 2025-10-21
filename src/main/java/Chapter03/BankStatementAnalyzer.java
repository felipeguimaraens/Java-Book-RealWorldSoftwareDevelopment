package Chapter03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {
    static final String RESOURCES = "src/main/resources/";

    public void analyze(String fileName, BankStatementParser bankParser, Exporter exporter) throws IOException {
        Path path = Paths.get(RESOURCES + fileName);
        List<String> lines = Files.readAllLines(path);
        List<BankTransaction> bankTransactions = bankParser.parseLinesFrom(lines);
        BankStatementProcessor bankProcessor = new BankStatementProcessor(bankTransactions);

        SummaryStatistics summaryStatistics = bankProcessor.summarizeTransactions();

        System.out.println(exporter.export(summaryStatistics));
    }
}
