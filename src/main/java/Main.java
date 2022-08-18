import csvReader.CSVReader;
import utils.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //CSVReader.readCsv("W:\\testTaskForRenue\\TestTask\\src\\main\\resources\\airports.csv");
        List<Integer> integers = new ArrayList<>();
        BinaryTree<Integer> tree = new BinaryTree<>();
        for (int i = 0; i < 15; i++)
            integers.add((int) (Math.random() * 31) - 15);
        for (int i = 0; i < 15; i++) {
            tree.addBranch(integers.get(i));
        }
        tree.printTree();

    }
}
