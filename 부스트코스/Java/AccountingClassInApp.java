class Accounting2{
    public double valueOfSupply;
    public double vatRate;
    public double expenseRate;

    public void print() {
        System.out.println("Value of supply : " + valueOfSupply);
        System.out.println("VAT : " + getVat());
        System.out.println("Total : " + getTotal());
        System.out.println("Expense : " + getExpense());
        System.out.println("Income : " + getIncome());
        System.out.println("Dividend1 : " + getDividend1());
        System.out.println("Dividend1 : " + getDividend2());
        System.out.println("Dividend1 : " + getDividend3());
    }

    private double getDividend1() {
        return getIncome() * 0.5;
    }
    private double getDividend2() {
        return getIncome() * 0.3;
    }
    private double getDividend3() {
        return getIncome() * 0.2;
    }

    private double getIncome() {
        return valueOfSupply - getExpense();
    }

    private double getExpense() {
        return valueOfSupply * expenseRate;
    }

    private double getTotal() {
        return getVat() + valueOfSupply;
    }

    private double getVat() {
        return valueOfSupply * vatRate;
    }
}

public class AccountingClassInApp {


    public static void main(String[] args) {
        Accounting2 a2 = new Accounting2();

        a2.valueOfSupply = Double.parseDouble(args[0]);
        a2.vatRate =0.1;
        a2.expenseRate = 0.3;

        a2.print();
    }


}
