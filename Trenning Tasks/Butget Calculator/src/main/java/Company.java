import java.util.ArrayList;

public class Company {
    protected String name;
    protected Double budget;
    protected ArrayList<Employee> employees = new ArrayList<Employee>();

    public Company(double budget, String name)
    {
        this.name = name;
        this.budget = budget;
    }

    public void addEmployee(Employee createNewOne)
    {
        this.employees.add(createNewOne);
    }

    public SalaryService getSalaryService()
    {
        return new SalaryService();
    }
}
