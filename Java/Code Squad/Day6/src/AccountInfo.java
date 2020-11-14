import java.io.FileOutputStream;


public class AccountInfo {

     private int PN;
     private String Date;
     private String Summary;
     private int Income;
     private int Expenditure;
     private String Type;

     public String getDate() {
          return Date;
     }

     public void setDate(String date) {
          Date = date;
     }

     public String getSummary() {
          return Summary;
     }

     public void setSummary(String summary) {
          Summary = summary;
     }

     public int getIncome() {
          return Income;
     }

     public void setIncome(int income) {
          Income = income;
     }

     public int getExpenditure() {
          return Expenditure;
     }

     public void setExpenditure(int expenditure) {
          Expenditure = expenditure;
     }

     public String getType() {
          return Type;
     }

     public void setType(String type) {
          Type = type;
     }

     public void showInfo(){
          System.out.println("결제 타입: "+this.Type);
          System.out.println("날짜: "+this.Date);
          System.out.println("적요: "+this.Summary);
          System.out.println("수입: "+this.Income);
          System.out.println("지출: "+this.Expenditure);

     }

     public int getPN() {
          return PN;
     }

     public void setPN(int PN) {
          this.PN = PN;
     }
}
