
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Bank {

    private ArrayList<Employee> employees;

    public Bank(int numberCashier, int numberSupervisor, int numberDirector) {
        createEmployees(numberCashier,numberSupervisor,numberDirector);
    }

    private void createEmployees(int numberCashier, int numberSupervisor, int numberDirector) {
        employees = new ArrayList<>();
        createCashiers(numberCashier);
        createSupervisor(numberSupervisor);
        createDirector(numberDirector);
    }

    public void createCashiers(int numberCashier){
        for(int i = 1; i <= numberCashier;i++){
            employees.add(new Cashier(i,true));
        }
    }

    public void createSupervisor(int numberSupervisor){
        for (int i = 1; i<= numberSupervisor; i++){
            employees.add(new Supervisor(i,true));
        }
    }

    public void createDirector(int numberDirector){
        for(int i = 1; i <= numberDirector; i++){
            employees.add(new Director(i,true));
        }
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }
}
