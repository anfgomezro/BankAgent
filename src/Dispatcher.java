import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class Dispatcher {

    private Bank bank;
    private ExecutorService executor;
    private int count = 0;

    public Dispatcher(Bank bank, ExecutorService executor) {
        this.bank = bank;
        this.executor = executor;
    }

    public void attend(){
        while(count < 10){
            for(Employee employees : bank.getEmployees()){
                if(employees.isStatus()){
                    Client client = new Client(employees,count);
                    CompletableFuture<String> future = CompletableFuture.supplyAsync(client,executor).thenAccept((n) -> {
                        System.out.println(n);
                    });
                    employees.setStatus(false);
                    count++;
                    break;
                }
            }
        }
        executor.shutdown();
        while(!executor.isTerminated()){
        }
        System.out.println("Finished all Clients");
        }

}
