import java.rmi.Remote;
import java.util.List;

public interface WordAnalyzer extends Remote {
    List<String> findLongestAndShortestWords(String filename) throws Exception;
}
