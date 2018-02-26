import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class Dispatcher {

    private static Dispatcher dispatcher = new Dispatcher();
    private Bank bank;
    private ExecutorService executor;
    private int numberClients;

    public  static  Dispatcher getInstance(){
        return dispatcher;
    }

    private Dispatcher(){ }

    public void constructDispatcher(Bank bank, ExecutorService executor, int numberClients){
        this.bank = bank;
        this.executor = executor;
        this.numberClients = numberClients;

    }

    public void attend(){
        int clientId = 0;
        while(clientId < numberClients){
            for(Employee employees : bank.getEmployees()){
                if(employees.isStatus()){
                    Client client = new Client(employees, clientId, generateTransaction(), new Account(1));
                    CompletableFuture
                            .supplyAsync(client,executor)
                            .thenAccept(message -> {
                        try {
                            sendMessage(message);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
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

    private void sendMessage(Message message){
        getAuditChain().logProcess(AuditModule.TT_DEPOSIT_TV_10000,message);
    }

    private AuditModule getAuditChain() {
        AuditModule depositOverTenthousand = new AuditDeposit(AuditModule.TT_DEPOSIT_TV_10000);
        depositOverTenthousand.nextAuditModule(null);
        return depositOverTenthousand;
    }


    private Transaction generateTransaction(){
        Transaction transaction = null;
        int balance = new Random().nextInt(5000)+10000;
        int value = new Random().nextInt(10000)+100;
        int t = new Random().nextInt(2);
        switch (0){
            case 0:
                transaction = new Deposit(balance,11000);
                break;
            case 1:
                transaction =  new Withdrawal(balance,value);
                break;
            case 2:
                transaction =  new QueryBalance(balance);
                break;
        }
        return transaction;
    }
}
