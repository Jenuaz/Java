import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Company a = new Company(10000000, "CastOverTimes");
        for (int i = 0; i < 5; i++){
            Employee employee = new Employee(5 , 10 );
            a.addEmployee(employee);
        }
        for (int i = 0; i < 5; i++){
            Developer dev = new Developer(5 , 10 , 100);
            a.addEmployee(dev);
        }
        SalaryService sc = a.getSalaryService();
        sc.pay(a);
    }
}
