import java.io.BufferedReader;
import java.io.FileReader;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class WordAnalyzerImpl extends UnicastRemoteObject implements WordAnalyzer {
    public WordAnalyzerImpl() throws Exception {
        super();
    }

    @Override
    public List<String> findLongestAndShortestWords(String filename) throws Exception {
        List<String> words = new ArrayList<>();
        String longestWord = "";
        String shortestWord = "";

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] lineWords = line.split("\\s+");
            for (String word : lineWords) {
                words.add(word);
                if (longestWord.isEmpty() || word.length() > longestWord.length()) {
                    longestWord = word;
                }
                if (shortestWord.isEmpty() || word.length() < shortestWord.length()) {
                    shortestWord = word;
                }
            }
        }
        reader.close();

        List<String> result = new ArrayList<>();
        result.add(longestWord);
        result.add(shortestWord);
        return result;
    }
}
