import java.util.Calendar;
import java.util.Date;

public  abstract class Transaction {
    protected float balance;


    public float getBalance() {
        return balance;
    }

    public Transaction(int balance) {
        this.balance = balance;
    }

    public abstract float newBalance();
    public abstract String getType();
    public abstract float getValue();

    public String getDate() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DATE)+"/"+calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.YEAR);
    }

}
