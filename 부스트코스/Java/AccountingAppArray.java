public class AccountingAppArray {
    public static void main(String[] args) {

        double valueOfSupply = Double.parseDouble(args[0]);
        double VAT = valueOfSupply * 0.1;
        double total = VAT + valueOfSupply;
        double Expense = valueOfSupply * 0.3;
        double Income = valueOfSupply - Expense;
        double Dividend1, Dividend2, Dividend3;

        double[] dividendRates = {0.5, 0.3, 0.2};
        // 변수가 많아질수록 데이터가 손상될 가능성이 높아지니, 배열을 사용하는 것이 더 좋음.

        Dividend1 = Income * dividendRates[0];
        Dividend2 = Income * dividendRates[1];
        Dividend3 = Income * dividendRates[2];

        System.out.println("Value of supply : " + valueOfSupply);
        System.out.println("VAT : " + VAT);
        System.out.println("Total : " + total);
        System.out.println("Expense : " + Expense);
        System.out.println("Income : " + Income);
        System.out.println("Dividend1 : " + Dividend1);
        System.out.println("Dividend1 : " + Dividend2);
        System.out.println("Dividend1 : " + Dividend3);
    }
}
