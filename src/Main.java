import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Калинин");
        System.out.println("22ПОИТ1з");

        //System.out.println("Curr dir " + Paths.get(".").toAbsolutePath());
        List<BankOperation> operationList = FileReader.readFromFile("data.txt");
    }
}
