package Chapter02;

public class MainChapterTwo {
    public static void main(String[] args) throws Exception {
        BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        BankStatementParser bankStatementParserCSV = new BankStatementCSVParser();
        BankStatementParser bankStatementParserJSON = new BankStatementJSONParser();

        bankStatementAnalyzer.analyze("bank-data-simple.csv", bankStatementParserCSV);
        bankStatementAnalyzer.analyze("bank-data-simple.json", bankStatementParserJSON);
    }
}
