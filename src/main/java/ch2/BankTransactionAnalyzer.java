package ch2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankTransactionAnalyzer {
    private static final String RESOURCES = "src/main/resources/";

    public static void main(String[] args) throws IOException {
        List<String> lines = getTransactionLines(args);

        BankStatementParser bankStatementCSVParser = new BankStatementCSVParser();
        List<BankTransaction> bankTransactions = bankStatementCSVParser.parseLinesFrom(lines);
        BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);
    }

    private static List<String> getTransactionLines(String[] args) throws IOException {
        String fileName = args[0];
        Path path = Paths.get(RESOURCES + fileName);
        return Files.readAllLines(path);
    }

    private static void collectSummary(BankStatementProcessor bankStatementProcessor) {
        System.out.println("bankStatementProcessor.calculateTotalAmount() = " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("bankStatementProcessor.calculateTotalMonth(Month.JANUARY) = " + bankStatementProcessor.calculateTotalMonth(Month.JANUARY));
        System.out.println("bankStatementProcessor.calculateTotalForCategory(\"Salary\") = " + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }
}
