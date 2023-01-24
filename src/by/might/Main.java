package by.might;

import org.magiclen.magicsort.MagicSort;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Александр Лишик");
        System.out.println("22ПОИТ1з");

        new Process(Paths.get(Constants.fileName)).run();
    }
}
