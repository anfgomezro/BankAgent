import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank(4,2,1);
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Dispatcher dispatcher = new Dispatcher(bank,executor);
        dispatcher.attend();
    }
}
