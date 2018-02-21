import java.util.Date;

public class Message {

    private int customerID;
    private String customerEmail;
    private int agentId;
    private String messageType;
    private int accountId;
    private String transactionDate;
    private float transactionValue;
    private String transactionType;

    public Message(Client client, Employee employee,String message) {
        this.customerID = client.getId();
        this.transactionDate = client.getTransaction().getDate();
        this.transactionValue = client.getTransaction().getValue();
        this.transactionType = client.getTransaction().getType();
        this.customerEmail = client.getEmail();
        this.agentId = employee.getId();
        this.messageType = message;
        this.accountId = client.getAccount().getId();

    }

    public int getCustomerID() {
        return customerID;
    }

    public int getAccountId() {
        return accountId;
    }

    public float getTransactionValue() {

        return transactionValue;
    }

    public String getTransactionType() {
        return transactionType;
    }
}
