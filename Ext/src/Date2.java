import java.util.Calendar;
import java.util.Date;
public class Date2 {
    public static void main(String[] args){
        //实例化日期对象
        var d = new Date();

        //获取当地时间
        System.out.println(d.toLocaleString());

        //返回自1970年1月1日午夜至现在的毫秒数(时间戳)，是一个long整数
        System.out.println(d.getTime());

        //获得系统时间，单位为毫秒；new Date()相当于调用System.currentTimeMillis()，若只需毫秒显示会降低效率
        System.out.println(System.currentTimeMillis());

        //直接获取系统时间，单位为毫秒
        long totalMilliSeconds=System.currentTimeMillis();
        //long totalSeconds = totalMilliSeconds/1000;   //转换为秒
        System.out.println(totalMilliSeconds);
    }
}
