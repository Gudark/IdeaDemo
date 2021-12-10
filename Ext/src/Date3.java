import java.util.Date;
public class Date3 {
    public static void main(String[] args) {
        Date d = new Date();
        //年月日 时分秒24制 当前时间信息 换行
        System.out.printf("%tF %tT %tc%n", d, d, d);
        //年月日 时分秒24 当前时间信息 pm标记 星期
        System.out.printf("%tF %1$tT %1$tc %1$tp %1$tA%n", d);
        //
        System.out.printf("%tF %1$tT %1$tA%n", d);
        //年月日时分秒_系统至现在所经过的秒数.jpg
        String str = String.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS_%1$ts.jpg%n", d);
        System.out.println(str);
        System.out.println();
        //格式输出系统时间 年月日 时分秒24 星期
        System.out.printf("%tF %1$tT %1$tA%n", System.currentTimeMillis());
        // 年 月 日  时 分 秒
        System.out.printf("%1$tY年%1$tm月%1$td日 %1$tH时%1$tM分%1$tS秒 %1$tA", System.currentTimeMillis());
    }
}
