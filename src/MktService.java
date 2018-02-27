abstract public class MktService{

    public void updateInformation(String customerID, Double transactionValue, String email) {
        System.out.println("Check value :" + transactionValue);
        this.sendAD(customerID, email);
    }

    abstract public void sendAD(String CustomerID, String email);
}
