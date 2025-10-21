import Chapter02.BankStatementCSVParser;
import Chapter02.BankStatementParser;
import Chapter02.BankTransaction;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

public class BankStatementCSVParserTest {
    BankStatementParser statementParser = new BankStatementCSVParser();

    @Test
    public void shouldParserOneCorrectLine() throws Exception {
        String line = "30-01-2017,-50,Tesco";
        BankTransaction result = statementParser.parseFrom(line);
        BankTransaction testCase = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");

        Assert.assertEquals(testCase.getDate(), result.getDate());
        Assert.assertEquals(testCase.getAmount(), result.getAmount(), 0.0d);
        Assert.assertEquals(testCase.getDescription(), result.getDescription());
    }
}
