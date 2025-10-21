package Chapter02;

import org.json.JSONObject;
import org.json.JSONArray;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementJSONParser implements BankStatementParser {
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public BankTransaction parseFrom(String line) {
        JSONObject json = new JSONObject(line);
        String dateStr = json.getString("date");
        LocalDate date = LocalDate.parse(dateStr, DATE_PATTERN);
        double amount = json.getDouble("amount");
        String description = json.getString("description");

        return new BankTransaction(date, amount, description);
    }

    @Override
    public List<BankTransaction> parseLinesFrom(List<String> lines) {
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            sb.append(line.trim());
        }
        String jsonContent = sb.toString();

        JSONArray jsonArray = new JSONArray(jsonContent);
        List<BankTransaction> bankTransactions = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject json = jsonArray.getJSONObject(i);
            String dateStr = json.getString("date");
            LocalDate date = LocalDate.parse(dateStr, DATE_PATTERN);
            double amount = json.getDouble("amount");
            String description = json.getString("description");
            bankTransactions.add(new BankTransaction(date, amount, description));
        }

        return bankTransactions;
    }


}
