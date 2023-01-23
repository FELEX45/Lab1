package by.might;

import java.util.Comparator;

public class Sort {

    public static class BankOperationDescUpComparator implements Comparator<BankOperation>{

        @Override
        public int compare(BankOperation o1, BankOperation o2) {
            return o1.description.compareTo(o2.description);
        }
    }

    public static class BankOperationAccountComparator implements Comparator<BankOperation>{

        @Override
        public int compare(BankOperation o1, BankOperation o2) {
            int accountCompare = o1.account.compareTo(o2.account);
            if (accountCompare == 0) {
                int typeCompare = o1.type.compareTo(o2.type);
                if (typeCompare == 0) {
                    return Double.compare(o2.amount, o1.amount);
                }
                return typeCompare;
            }
            return accountCompare;
        }
    }
}
