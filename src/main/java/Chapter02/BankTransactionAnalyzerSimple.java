package Chapter02;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;


public class BankTransactionAnalyzerSimple {
    private static final String RESOURCES = "src/main/resources/";

    public static void main(String... args) throws IOException {
        // For some reason the author of the book have some fetish with
        // "final" keyword. I removed some of those.
        String fileName = "bank-data-simple.csv";
        Path path = Paths.get(RESOURCES + fileName);
        List<String> lines = Files.readAllLines(path);
        double total = 0d;
        int januaryCount = 0;
        DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        for (String line : lines) {
            String[] columns = line.split(",");
            double amount = Double.parseDouble(columns[1]);
            LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
            if(date.getMonth() == Month.JANUARY) januaryCount++;
            total += amount;
        }
        System.out.println("The total for all transaction is " + total);
        System.out.println("We have in January " + januaryCount + " transations");
    }
}
