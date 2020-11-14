import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public void FileWrite(String directory, String name, List<AccountInfo> InfoList)throws IOException {
        OutputStream out = null;
        try {
            File dirent = new File(directory);

            if (!dirent.exists()) {
                dirent.mkdir();
            }

            File outFile = new File(directory, name);

            if (outFile.exists()) {
                outFile.delete();
            }

           out = new BufferedOutputStream(new FileOutputStream(outFile));
 //           PrintWriter pw = new PrintWriter("/Users/jeongjiwon/codesquad_cocoa/DAY6/Mission 3,4/DB.txt");
            for (int index = 0; index < InfoList.size(); index++) {
                String writeStr = InfoList.get(index).getType() + " / " + InfoList.get(index).getDate()
                        + " / " + InfoList.get(index).getSummary() + " / " + InfoList.get(index).getIncome()
                        + " / " + InfoList.get(index).getExpenditure() + "\n";
                byte[] b = writeStr.getBytes();

                out.write(b);
//                pw.print(writeStr);
            }
        } catch (Exception e) { // 오류 발생시 잡는 구문
        }
    }

    public static List<AccountInfo> readFile(File file) throws IOException {
        FileReader fileReader = null;
        List<AccountInfo> InfoList = new ArrayList<AccountInfo>();

        try {
            fileReader = new FileReader(file);
            InfoList = readReader(fileReader);
        } finally {
            if(fileReader != null){
                fileReader.close();
            }
            return InfoList;
        }
    }

    public static List<AccountInfo> readReader(Reader input) throws IOException {
        try {
            //파일의 내용을 읽어들일 BufferReader 객체 생성
            BufferedReader in = new BufferedReader(input);
            String line;

            List<AccountInfo> InfoList = new ArrayList<AccountInfo>();

            //파일을 한줄씩 읽어간다.
            while((line=in.readLine()) != null) {
                // "/"로 split하여 배열에 저장
                String[] writeStr = line.split("/");

                // 모든 정보가 저장되어 있지 않다면 skip한다.
                if(writeStr.length != 6) continue;

                AccountInfo accountInfo = new AccountInfo();

                //각 개인정보를 저장한다.
                accountInfo.setPN(Integer.parseInt(writeStr[0]));
                accountInfo.setType(writeStr[1]);
                accountInfo.setDate(writeStr[2]);
                accountInfo.setSummary(writeStr[3]);
                accountInfo.setIncome(Integer.parseInt(writeStr[4]));
                accountInfo.setExpenditure(Integer.parseInt(writeStr[5]));

                //리스트에 객체 추가.
                InfoList.add(accountInfo);
            }

            return InfoList;
        } finally {
            input.close();
        }
    }
}
//