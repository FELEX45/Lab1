package by.might;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    public static List<BankOperation> sortADDOperation(List<BankOperation> input) {
        List<BankOperation> out = new ArrayList<>();
        for (BankOperation bankOperation : input) {
            if (bankOperation.type.equals(BankOperation.TypeOperation.ADD.name())) {
                out.add(bankOperation);
            }
        }
        return out;
    }

    public static List<BankOperation> sortNov2021(List<BankOperation> input) {
        List<BankOperation> out = new ArrayList<>();
        for (BankOperation bankOperation : input) {
            if (bankOperation.date_year == 2021 && bankOperation.date_month == 10) {
                out.add(bankOperation);
            }
        }
        return out;
    }
}
