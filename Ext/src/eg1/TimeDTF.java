package eg1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeDTF {
    public static void main(String[] args) {

        //新的格式化类型 DateTimeFormatter可以自定义格式化输出
        //自定义格式化
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()));

        //使用自定义格式解析输出
        LocalDateTime ldt = LocalDateTime.parse("2021/12/11 10:19:12", dtf);
        System.out.println(ldt);
    }
}
