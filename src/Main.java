import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        init();
    }

    public static void init(){
        Scanner sn = new Scanner(System.in);
        System.out.println("How many Cashiers do you want?");
        int numberCashiers = sn.nextInt();
        System.out.println("How many Supervisors do you want?");
        int numberSupervisors = sn.nextInt();
        System.out.println("How many Directors do you want?");
        int numberDirectors = sn.nextInt();
        System.out.println("How many Clients do you want?");
        int numberClients = sn.nextInt();
        start(numberCashiers,numberSupervisors,numberDirectors,numberClients);
    }

    private static void start(int numberCashiers,int numberSupervisors, int numberDirector, int numberClients) {
        Bank bank = new Bank(numberCashiers,numberSupervisors,numberDirector);
        ExecutorService executor = Executors.newFixedThreadPool(numberClients);
        Dispatcher dispatcher = new Dispatcher(bank,executor,numberClients);
        dispatcher.attend();
    }
}
