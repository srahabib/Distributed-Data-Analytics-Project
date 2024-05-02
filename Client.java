import java.rmi.Naming;
import java.util.List;

public class Client {
    public static void main(String[] args) throws Exception {
        WordAnalyzer analyzer = (WordAnalyzer) Naming.lookup("WordAnalyzer");
        List<String> result = analyzer.findLongestAndShortestWords("E:\\Distributed Data Analytics Project\\Text.txt");
        System.out.println("Longest word: " + result.get(0));
        System.out.println("Shortest word: " + result.get(1));
    }
}
