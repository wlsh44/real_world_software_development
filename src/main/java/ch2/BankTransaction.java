package ch2;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class BankTransaction {

    private final LocalDate date;
    private final double amount;
    private final String description;
}
