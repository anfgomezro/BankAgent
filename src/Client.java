import java.util.Random;

public class Client implements Runnable {

    private Employee employee;
    private int id;

    public Client(Employee employee, int id) {
        this.employee = employee;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "(Start) Client "+ getId()+" Attend by: " + getEmployee().getClass()+ " with id: "+ getEmployee().getId());
        int n = new Random().nextInt(5000)+10000;
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "(End) Client " + getId()+ " Time:" + n +"ms");
        employee.setStatus(true);
    }
}
