package Chapter03;

public class MainChapterThree {

    public static void main(String[] args) throws Exception {
        BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        BankStatementParser bankStatementParser = new BankStatementCSVParser();

        Exporter exporter = new HtmlExporter();

        bankStatementAnalyzer.analyze("bank-data-simple.csv", bankStatementParser, exporter);
    }
}
