public class Director extends Employee {
    public Director(int id, boolean status) {
        super(id,status);
    }

    @Override
    public String getType() {
        return "Director";
    }
}
