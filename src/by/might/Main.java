package by.might;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Калинин");
        System.out.println("22ПОИТ1з");

        //System.out.println("Curr dir " + Paths.get(".").toAbsolutePath());
        List<BankOperation> operationList = FileReader.readFromFile("data.txt");

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

        System.out.println("Сортируем");
        Collections.sort(operationList, new Sort.BankOperationDescUpComparator());
        operationList.forEach(System.out::println);
    }
}
