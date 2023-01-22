package by.might;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    public static List<BankOperation> readFromFile(String name) throws IOException {
        List<String> files =  Files.readAllLines(Paths.get(name));
        List<BankOperation> operations = new ArrayList<>();
        for (String file : files) {
            String[] split = file.split(" ");

            operations.add(new BankOperation(
                    Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]),//Дата
                    Integer.parseInt(split[3]), Integer.parseInt(split[4]), Integer.parseInt(split[5]),//Время
                            split[6], split[7], Double.parseDouble(split[8]), split[9]//Тип, аккаунт, сумма, описание

            ));
        }
        return operations;
    }
}
