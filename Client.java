import javax.swing.*;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;
import java.io.File;

public class Client {
    public static void main(String[] args) throws Exception {
        // Create a file chooser dialog
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();

            // Connect to the WordAnalyzer server
            WordAnalyzer analyzer = (WordAnalyzer) Naming.lookup("WordAnalyzer");

            // Call the server method to find longest and shortest words
            try {
                List<String> resultWords = analyzer.findLongestAndShortestWords(filePath);
                System.out.println("Longest word: " + resultWords.get(0));
                System.out.println("Shortest word: " + resultWords.get(1));
            } catch (RemoteException e) {
                System.err.println("Error communicating with the server: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("File selection canceled.");
        }
    }
}
