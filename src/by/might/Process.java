package by.might;

import org.magiclen.magicsort.MagicSort;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Process implements Runnable {
    private final List<BankOperation> operations;
    private final Path fileName;

    public Process(Path filename) {
        operations = loadOperations();
        this.fileName = filename;
    }

    public List<BankOperation> getOperations() {
        return operations;
    }

    @Override
    public void run() {
        //System.out.println("Curr dir " + Paths.get(".").toAbsolutePath());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Фильтрация данных");
        System.out.println("1. Вывести все банковские приходные операции");
        System.out.println("2. Вывести все банковские операции за ноябрь 2021 года.");
        System.out.println("Выберите операцию для фильтрации");

        int read = scanner.nextInt();
        filterAndPrint(operations, read);

        System.out.println("Выберите алгоритм сортировки");
        System.out.println("1. Сортировка выбором (Selection sort)");
        System.out.println("2. Быстрая сортировка (Quick sort)");
        read = scanner.nextInt();

        System.out.println("Выберите Критерии сортировки");
        System.out.println("1. По возрастанию назначения платежа");
        System.out.println("По возрастанию номера счёта, а в рамках одного счёта по возрастанию вида операции, а в рамках одного вида операции по убыванию суммы операции");
        int type = scanner.nextInt();


        System.out.println("Сортируем");
        sortAndPrint(operations, read, type);
    }

    private List<BankOperation> loadOperations() {
        try {
            return  FileReader.readFromFile(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void filterAndPrint(List<BankOperation> operationList, int read) {
        if (read == 1) {
            Filter.sortADDOperation(operationList).forEach(System.out::println);
        }
        else if (read == 2) {
            Filter.sortNov2021(operationList).forEach(System.out::println);
        }
    }

    public void sortAndPrint(List<BankOperation> operationList, int algo, int type) {
        MagicSort.Algorithm sorting = algo == 1 ? MagicSort.Algorithm.SELECTIONSORT : MagicSort.Algorithm.QUICKSORT;
        Comparator<BankOperation> comparator = type == 1 ? new Sort.BankOperationDescUpComparator() : new Sort.BankOperationAccountComparator();
        Arrays.asList(Sort.sortSelect(operationList, comparator, sorting)).forEach(System.out::println);
    }
}
