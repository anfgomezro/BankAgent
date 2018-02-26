public class Cashier extends Employee {

    public Cashier(int id, boolean status) {
        super(id,status);
    }

    @Override
    public String getType() {
        return "Cashier";
    }
}
