import java.util.Calendar;
import java.util.Date;

public class Withdrawal extends Transaction {

    private float withdrawal;
    public Withdrawal(int balance,int withdrawal) {
        super(balance);
        this.withdrawal = withdrawal;
    }

    @Override
    public float newBalance() {
        return balance - withdrawal;
    }

    @Override
    public String getType() {
        return "WirhDrawal";
    }

    @Override
    public float getValue() {
        return withdrawal;
    }
}
