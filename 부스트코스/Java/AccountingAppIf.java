public class AccountingAppIf {
    public static void main(String[] args) {

        double valueOfSupply = Double.parseDouble(args[0]);
        double VAT = valueOfSupply * 0.1;
        double total = VAT + valueOfSupply;
        double Expense = valueOfSupply * 0.3;
        double Income = valueOfSupply - Expense;
        double Dividend1, Dividend2, Dividend3;

        if(Income>10000.0){
            Dividend1 = Income * 0.5;
            Dividend2 = Income * 0.3;
            Dividend3 = Income * 0.2;
        } else {
                Dividend1 = Income * 1;
                Dividend2 = Income * 0;
                Dividend3 = Income * 0;
        }

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
