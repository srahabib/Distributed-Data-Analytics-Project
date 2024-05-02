import java.rmi.Naming;

public class Server {
    public static void main(String[] args) throws Exception {
        WordAnalyzerImpl analyzer = new WordAnalyzerImpl();
        Naming.rebind("WordAnalyzer", analyzer);
        System.out.println("WordAnalyzer server started.");
    }
}
