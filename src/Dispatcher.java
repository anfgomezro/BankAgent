import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

public class Dispatcher {

    private Bank bank;
    private ExecutorService executor;


    public Dispatcher(Bank bank, ExecutorService executor) {
        this.bank = bank;
        this.executor = executor;
    }

    public void attend(){
        int clientId = 0;
        while(clientId < 10){
            for(Employee employees : bank.getEmployees()){
                if(employees.isStatus()){
                    Client client = new Client(employees,clientId);
                    CompletableFuture<String> future = CompletableFuture.supplyAsync(client,executor).thenAccept((n) -> {
                        System.out.println(n);
                    });
                    employees.setStatus(false);
                    clientId++;
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
