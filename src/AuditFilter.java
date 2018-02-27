import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AuditFilter extends AuditModule{

    public AuditFilter(int level){
        this.level = level;
    }

    @Override
    public void processMessage(Message message) {
        if(message.getTransactionType().equals("Deposit") && message.getTransactionValue() > 10000){
            writeInFile(message);
        }
    }

    private void writeInFile(Message message){
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

