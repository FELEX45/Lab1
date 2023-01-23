package by.might;

import org.magiclen.magicsort.MagicSort;

import java.util.Comparator;
import java.util.List;

public class Sort {

    public static BankOperation[] sortSelect(List<BankOperation> operations, Comparator<BankOperation> comparator, MagicSort.Algorithm algorithm) {
        MagicSort<BankOperation> sort = new MagicSort<>(operations.toArray(new BankOperation[0]));
        sort.setAlgorithm(algorithm);
        sort.setComparator(comparator);
        sort.sort();
        return sort.getData();
    }

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
