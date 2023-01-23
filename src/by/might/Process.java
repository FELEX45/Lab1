package by.might;

import org.magiclen.magicsort.MagicSort;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Process implements Runnable {

    @Override
    public void run() {
        //System.out.println("Curr dir " + Paths.get(".").toAbsolutePath());
        List<BankOperation> operationList = null;
        try {
            operationList = FileReader.readFromFile(Constants.fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Фильтрация данных");
        System.out.println("1. Вывести все банковские приходные операции");
        System.out.println("2. Вывести все банковские операции за ноябрь 2021 года.");
        System.out.println("Выберите операцию для фильтрации");

        int read = scanner.nextInt();
        if (read == 1) {
            Filter.sortADDOperation(operationList).forEach(System.out::println);
        }
        else if (read == 2) {
            Filter.sortNov2021(operationList).forEach(System.out::println);
        }

        System.out.println("Выберите алгоритм сортировки");
        System.out.println("1. Сортировка выбором (Selection sort)");
        System.out.println("2. Быстрая сортировка (Quick sort)");
        read = scanner.nextInt();

        MagicSort.Algorithm sorting = read == 1 ? MagicSort.Algorithm.SELECTIONSORT : MagicSort.Algorithm.QUICKSORT;
        System.out.println("Выберите Критерии сортировки");
        System.out.println("1. По возрастанию назначения платежа");
        System.out.println("По возрастанию номера счёта, а в рамках одного счёта по возрастанию вида операции, а в рамках одного вида операции по убыванию суммы операции");
        read = scanner.nextInt();

        Comparator<BankOperation> comparator = read == 1 ? new Sort.BankOperationDescUpComparator() : new Sort.BankOperationAccountComparator();
        System.out.println("Сортируем");
        Arrays.asList(Sort.sortSelect(operationList, comparator, sorting)).forEach(System.out::println);
    }
}
