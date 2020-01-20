public class SalaryService {

    public void pay(Company currentCompany)
    {
        int     i;
        double checkBudget;

        i = 1;
        checkBudget = currentCompany.budget;
        System.out.println("COMPANY BUDGET "+ checkBudget);
        for(Employee tmp : currentCompany.employees) {
            checkBudget -= tmp.getSalery();
            System.out.println("Debug budget: " + checkBudget + " lefts in budget after payed for " + i++ + " employee.");
        }
        System.out.println((checkBudget >= 0.0) ? "CURRENT BUDGET "+ checkBudget : "");
        System.out.println(
                (checkBudget >= 0.0) ? ("Salary was payed.\n" + "Budget now is: " + checkBudget) : ("Not enough budget to pay salary.")
        );
        if (checkBudget >= 0.0)
            currentCompany.budget -= checkBudget;
    }
}
