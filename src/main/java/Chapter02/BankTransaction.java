package Chapter02;

import java.time.LocalDate;
import java.util.Objects;

public class BankTransaction {
    private final LocalDate date;
    private final double amount;
    private final String description;

    public BankTransaction(LocalDate date, double amount, String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    LocalDate getDate() {
        return date;
    }

    double getAmount() {
        return amount;
    }

    String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "BankTransaction{" + "date:" + date +", amount:"
                + amount + ", description:'" + description + '\'' + "}";

    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount, description);
    }
}
