import java.util.Date;

public class Deposit extends Transaction {

    private float deposit;

    public Deposit(int balance,int deposit) {
        super(balance);
        this.deposit=deposit;
    }

    public float getDeposit() {
        return deposit;
    }

    @Override
    public float newBalance() {
        return balance + deposit;
    }

    @Override
    public String getType() {
        return "Deposit";
    }


    @Override
    public float getValue() {
        return deposit;
    }
}
