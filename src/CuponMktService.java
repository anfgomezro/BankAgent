public class CuponMktService extends MktService {

    @Override
    public void sendAD(String CustomerID, String email) {
        System.out.println("Sending Coupons to "+ CustomerID +" with email " +email);
    }
}
