import java.util.Date;

public class QueryBalance extends Transaction {

    public QueryBalance(int balance) {
        super(balance);
    }

    @Override
    public float newBalance() {
        return balance;
    }

    @Override
    public String getType() {
        return "QueryBalance";
    }



    @Override
    public float getValue() {
        return newBalance();
    }
}
