public class Developer extends Employee {
    protected double bonuces;

    public Developer()
    {
        return ;
    }

    public Developer(double rate, int workdays, double bonuces)
    {
        this.ratePerHour = rate;
        this.workdays = workdays;
        this.bonuces = bonuces;
    }

    public void setBonuces(double bonuces) {
        this.bonuces = bonuces;
    }

    public double getBonuces() {
        return bonuces;
    }

    @Override
    public double getSalery() {
        return (this.ratePerHour * this.workdays * WORK_HOURS + this.bonuces);
    }
}
