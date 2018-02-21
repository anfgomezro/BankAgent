import java.util.Random;
import java.util.function.Supplier;

public class Client implements Supplier<Message>{

    private Employee employee;
    private int id;
    private Transaction transaction;
    private String email;
    private Account account;

    public Client(Employee employee, int id,Transaction transaction,Account account) {
        this.employee = employee;
        this.id = id;
        this.transaction = transaction;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String balance(){
        return String.valueOf(transaction.newBalance());
    }

    public Transaction getTransaction() {
        return transaction;
    }

    @Override
    public Message get() {

        try {
            System.out.println(Thread.currentThread().getName() + "(Start) Client "+ getId()+" Attend by: " + getEmployee().getType()+ " with id: "+ getEmployee().getId());
            int n = new Random().nextInt(5000)+10000;
            Thread.sleep(n);
            Message message = new Message(this,employee,"mensaje");
            employee.setStatus(true);
            System.out.println(Thread.currentThread().getName() + "(End) Client " + getId()+ " Time:" + String.valueOf(n) + "ms" + " Transaction: " + getTransaction().getType() +" Balance: " + balance()+" $");
            return message;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
