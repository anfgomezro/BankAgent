import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AuditDeposit extends AuditModule {

    public AuditDeposit(int level){
        this.level = level;
    }

    @Override
    protected void processMessage(Message message) {
        if(message.getTransactionType().equals("Deposit") && message.getTransactionValue() > 10000){
            addMessagetoFile(message);
        }
    }

    private void addMessagetoFile(Message message){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath,true));
            bw.write(message.getCustomerID()+","+message.getAccountId()+","+message.getTransactionValue());
            bw.write("\n");
            bw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
