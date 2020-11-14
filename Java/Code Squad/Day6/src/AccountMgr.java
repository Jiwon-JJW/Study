import java.util.ArrayList;
import java.util.List;

public class AccountMgr {

    private static List<AccountInfo> InfoList = new ArrayList<>();
    //가계부 목록 별 고유 넘버.
    private int PN = 0;

    public List<AccountInfo> getInfoList() {
        return InfoList;
    }

    public void setInfoList(List<AccountInfo> infoList) {
        this.InfoList = infoList;
    }

    public int addInfo(AccountInfo accountInfo){
        int ret = 0;

        try {
            // 고유 번호 지정
            accountInfo.setPN(++this.PN);

            //list에 객체 추가.
            this.InfoList.add(accountInfo);
        } catch (Exception e){
            System.out.println("정보 추가 중 에러가 발생하였습니다." + "\n" + e.getMessage());
            //return값 변경(0 : 정상, 1 : 에러)
            ret = 1;
        }

        return ret;
    }
    public int removeInfo(int PN) {
        //성공여부 return 변수
        int ret = 0;

        try {
            //List개수만큼 for문
            for(int idx=0; idx < this.InfoList.size(); idx++) {
                AccountInfo tempAccountInfo = this.InfoList.get(idx);

                if(PN == tempAccountInfo.getPN()) {
                    //고유번호를 비교하여 같은 번호의 정보를 삭제한다.
                    this.InfoList.remove(idx);
                    break;
                }

                if(idx == this.InfoList.size()-1) {
                    ret = 2;
                }
            }
        }catch(Exception e) {
            System.out.println("정보 삭제 중 에러가 발생하였습니다." + "\n" + e.getMessage());
            //return값 변경(0 : 정상, 1 : 에러, 2 : 해당정보없음)
            ret = 1;
        }

        return ret;
    }

    /**
     * @param PN
     * @param accountInfo
     * @return
     */
    public int updateInfo(AccountInfo accountInfo, int PN) {
        //성공여부 return 변수
        int ret = 0;

        try {
            //List개수만큼 for문
            for(int idx=0; idx < this.InfoList.size(); idx++) {
                AccountInfo tempAccountInfo = this.InfoList.get(idx);

                if(PN == tempAccountInfo.getPN()) {
                    accountInfo.setPN(PN);

                    //고유번호를 비교하여 같은 번호의 정보를 수정한다.
                    this.InfoList.remove(idx);
                    this.InfoList.add(idx, accountInfo);
                    break;
                }

                if(idx == this.InfoList.size()-1) {
                    ret = 2;
                }
            }
        }catch(Exception e) {
            System.out.println("정보 수정 중 에러가 발생하였습니다." + "\n" + e.getMessage());
            //return값 변경(0 : 정상, 1 : 에러, 2 : 해당정보없음)
            ret = 1;
        }

        return ret;
    }


    public void showInfo() {
        System.out.println("=============================================================");
        System.out.println(" No / 소비 유형 /   날짜   /   적요   /   수입   /   지출   /   잔액  ");
        for(int idx=0; idx < this.InfoList.size(); idx++) {
//            int total = 0;
//            total = (total + this.InfoList.get(idx).getIncome() - this.InfoList.get(idx).getExpenditure());
            System.out.println(" " + idx + " / "+ this.InfoList.get(idx).getPN() +
                    " / " + this.InfoList.get(idx).getType() +
                    " / " + this.InfoList.get(idx).getDate() +
                    " / " + this.InfoList.get(idx).getSummary() +
                    " / " + this.InfoList.get(idx).getIncome() + "원 / "
                    + this.InfoList.get(idx).getExpenditure() + "원 / ");
                    // + total + "원 ");
            }
        System.out.println("=============================================================");
        System.out.println("출력이 완료되었습니다.");
        }
    }
