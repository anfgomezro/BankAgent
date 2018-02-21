public class Supervisor extends Employee {
    public Supervisor(int id, boolean status) {
        super(id,status);
    }

    @Override
    public String getType() {
        return "Supervisor";
    }
}
