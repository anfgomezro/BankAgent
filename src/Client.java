import java.util.Random;
import java.util.function.Supplier;

public class Client implements Supplier {

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
    public String get() {
        System.out.println(Thread.currentThread().getName() + "(Start) Client "+ getId()+" Attend by: " + getEmployee().getClass()+ " with id: "+ getEmployee().getId());
        int n = new Random().nextInt(5000)+10000;
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        employee.setStatus(true);
        return  Thread.currentThread().getName() + "(End) Client " + getId()+ " Time:" + String.valueOf(n) + "ms";
    }
}
