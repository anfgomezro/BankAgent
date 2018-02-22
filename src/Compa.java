import java.util.Comparator;

public class Compa implements Comparator<Employee> {


    @Override
    public int compare(Employee a, Employee b) {
        if(a.getPriority() > b.getPriority()){
            return 1;
        }else if(a.getPriority() < b.getPriority()){
            return  -1;
        }else {
            return 0;
        }
    }
}
