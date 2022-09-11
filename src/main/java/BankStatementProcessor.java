import lombok.AllArgsConstructor;

import java.time.Month;
import java.util.List;

@AllArgsConstructor
public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;

    public double calculateTotalAmount() {
        return bankTransactions.stream()
                .map(BankTransaction::getAmount)
                .reduce(0., Double::sum);
    }

    public double calculateTotalMonth(Month month) {
        return bankTransactions.stream()
                .filter(transaction -> filteringMonth(transaction, month))
                .map(BankTransaction::getAmount)
                .reduce(0., Double::sum);
    }

    public double calculateTotalForCategory(String category) {
        return bankTransactions.stream()
                .filter(transaction -> filteringCategory(transaction, category))
                .map(BankTransaction::getAmount)
                .reduce(0., Double::sum);
    }

    private boolean filteringCategory(BankTransaction transaction, String category) {
        return transaction.getDescription().equals(category);
    }

    private boolean filteringMonth(BankTransaction transaction, Month month) {
        return transaction.getDate().getMonth().equals(month);
    }
}
