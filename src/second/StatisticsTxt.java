package second;

import java.io.*;

public class StatisticsTxt {

    public long removeSpace(String filename){
        StringBuffer sb = new StringBuffer();
        try{
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while((line = br.readLine()) != null){
                String linetrim = line.trim().replaceAll("\\s",""); // \s能匹配任何空白字符
                sb.append(linetrim);
            }
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.length();

    }


    public static void main(String[] args) {
        String filename = "C:\\code\\lrgTestclass\\123.txt";
        StatisticsTxt st = new StatisticsTxt();
        st.removeSpace(filename);
        System.out.println(st.removeSpace(filename));

    }
}
