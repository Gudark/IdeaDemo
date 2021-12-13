package eg1;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class CalendarText {
    public static void main(String[] args) {
        //获取时间
        long t1 = System.currentTimeMillis();
        Date t2 = new Date();
        /*Calendar可以看作抽象类
         * 当获取Calendar实例时，Calendar会根据传入参数来返回相应的Calendar参数
         * 通过Calendar.getInstance()获取日历时，默认返回GregorianCalendar对象。
         * GregorianCalendar是Calendar的一个实现类，它提供了世界上大多数国家/地区所使用的标准日历系统*/
        //返回的17个字段保存在int数组中
        var t3 = Calendar.getInstance();
        LocalDateTime t4 = LocalDateTime.now();

        System.out.printf("%tc\n", t1);
        System.out.printf("%tc\n", t2);
        System.out.printf("%tc\n", t3);
        // ? 为什么不能直接格式化输出LocalDateTime ?
        //System.out.printf("%tc\n", t4);
        System.out.println(t4);
        System.out.printf("%tF\n", t3);
        System.out.printf("%tT\n", t3);
        System.out.printf("%tr\n", t3);
        System.out.printf("%1$tF %1$tT\n", t3);
        System.out.printf("%1$tY年%1$tm月%1$td日 %1$tT %1$tA\n", t2);

    }
}
