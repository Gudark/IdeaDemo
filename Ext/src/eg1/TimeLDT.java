package eg1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeLDT {
    public static void main(String[] args) {

        /* java 8开始新的日期时间 API，运算方便，修正不合理常量设计
        本地日期和时间：LocalDateTime，LocalDate，LocalTime；
        带时区的日期和时间：ZonedDateTime；
        时刻：Instant；
        时区：ZoneId，ZoneOffset；
        时间间隔：Duration。
        新 API几乎全是不变类型（类似String），不必担心被修改*/

        LocalDateTime dt = LocalDateTime.now();//当前日期和时间
        LocalDate d = dt.toLocalDate();//当前日期
        LocalTime t = dt.toLocalTime();//当前时间

        //新 API默认严格按照 ISO 8601规定格式打印
        System.out.println(dt);
        System.out.println(d);
        System.out.println(t);

        //通过 of（）方法指定日期和时间创建 LocalDateTime
        LocalDate d2 = LocalDate.of(2021, 12, 11);//2021-12-11,所见即所得
        LocalTime t2 = LocalTime.of(9, 40, 23);//09:40:23
        LocalDateTime dt1 = LocalDateTime.of(2021, 12, 11, 9, 40, 23);
        LocalDateTime dt2 = LocalDateTime.of(d2, t2);
        System.out.println(d2);
        System.out.println(t2);
        System.out.println(dt1);
        System.out.println(dt2);

        //将字符串转换为 LocalDateTime即可传入标准格式，日期时间分隔符为 T
        LocalDateTime dt3 = LocalDateTime.parse("2021-12-11T09:55:11");
        LocalDate d3 = LocalDate.parse("2021-12-11");
        LocalTime t3 = LocalTime.parse("09:55:11");
        System.out.println(dt3);
        System.out.println(d3);
        System.out.println(t3);
    }
}
