class Accounting{
    public static double valueOfSupply;
    public static double vatRate;
    public static double expenseRate;

    public static void print() {
        System.out.println("Value of supply : " + valueOfSupply);
        System.out.println("VAT : " + getVat());
        System.out.println("Total : " + getTotal());
        System.out.println("Expense : " + getExpense());
        System.out.println("Income : " + getIncome());
        System.out.println("Dividend1 : " + getDividend1());
        System.out.println("Dividend1 : " + getDividend2());
        System.out.println("Dividend1 : " + getDividend3());
    }

    private static double getDividend1() {
        return getIncome() * 0.5;
    }
    private static double getDividend2() {
        return getIncome() * 0.3;
    }
    private static double getDividend3() {
        return getIncome() * 0.2;
    }

    private static double getIncome() {
        return valueOfSupply - getExpense();
    }

    private static double getExpense() {
        return valueOfSupply * expenseRate;
    }

    private static double getTotal() {
        return getVat() + valueOfSupply;
    }

    private static double getVat() {
        return valueOfSupply * vatRate;
    }
}
public class AccountingClassApp {


    public static void main(String[] args) {
        Accounting.valueOfSupply = Double.parseDouble(args[0]);
        Accounting.vatRate =0.1;
        Accounting.expenseRate = 0.3;

        Accounting.print();

        // another Variable = ...;
        // another method = ...;
        // 다른 취지의 코드가 있으면 생산성을 떨어트리는 방해요소가 될 수 있으므로, 클래스를 사용
    }


}
