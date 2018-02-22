public class Cashier extends Employee {
<<<<<<< HEAD
    public Cashier(int id, boolean status,int priority) {
        super(id,status,priority);
=======

    public Cashier(int id, boolean status) {
        super(id,status);
>>>>>>> 9873565b3b0d264e911ebd656bfa0bdc888ee53a
    }

    @Override
    public String getType() {
        return "Cashier";
    }
}
