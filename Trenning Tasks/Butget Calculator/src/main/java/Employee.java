public class Employee {
    protected double ratePerHour;
    protected int workdays;
    protected static final int WORK_HOURS = 8;          //I think this have a point here. Specification of purpose.

    public Employee()
    {
        return ;
    }

    public Employee(double rate, int workdays)
    {
        this.ratePerHour = rate;
        this.workdays = workdays;
    }

    public double getSalery() {
        return (ratePerHour * workdays * WORK_HOURS);
    }

}
