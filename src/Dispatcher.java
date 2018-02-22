import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class Dispatcher {

    private Bank bank;
    private ExecutorService executor;
    private int numberClients;


    public Dispatcher(Bank bank, ExecutorService executor,int numberClients) {
        this.bank = bank;
        this.executor = executor;
        this.numberClients = numberClients;
    }

    public void attend(){
        int clientId = 0;
        while(clientId < numberClients){
            if(bank.getEmployees().size() > 0){
                Employee employee = bank.getEmployees().poll();
                CompletableFuture.supplyAsync(new Client(employee,clientId),executor).thenAccept((n) -> {
                    System.out.println(n);
                    System.out.println(bank.getEmployees().size());
                    returnEmployee((Employee) n);
                });
                clientId++;
                System.out.println(clientId);
            }
            /*
            for(Employee employees : bank.getEmployees()){
                if(employees.isStatus()){
                    Client client = new Client(employees,clientId);
                    CompletableFuture.supplyAsync(client,executor).thenAccept((n) -> {
                        System.out.println(n);
                    });
                    employees.setStatus(false);
                    clientId++;
                    break;
                }
            }*/
        }
        executor.shutdown();
        while(!executor.isTerminated()){
        }
        System.out.println("Finished all Clients");
        }

    private void returnEmployee(Employee n) {
        System.out.println("hi entre");
        bank.getEmployees().add(n);
    }

}
