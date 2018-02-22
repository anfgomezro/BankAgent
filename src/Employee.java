public abstract class Employee {

    private int id;
    private boolean status;
    private int priority;

    public Employee(int id,boolean status,int priority) {
        this.id = id;
        this.status = status;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
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

    public abstract String getType();
}
