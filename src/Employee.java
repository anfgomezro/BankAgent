public abstract class Employee {

    private int id;
    private boolean status;

    public Employee(int id,boolean status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
