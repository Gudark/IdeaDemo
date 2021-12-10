import java.util.Calendar;
import java.util.Locale;
public class Date {
    public static void main(String[] args){
        Calendar c = Calendar.getInstance(Locale.CHINA);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        System.out.println(hour);
        if(hour>=6 && hour<8){
            System.out.println("现在是:"+hour+"点 n早上好!");
        }else if(hour>=8 && hour<12){
            System.out.println("现在是:"+hour+"点 n上午好!");
        }else if(hour>=12 && hour<18){
            System.out.println("现在是:"+hour+"点 n下午好!");
        }else if(hour>=18 && hour<22){
            System.out.println("现在是:"+hour+"点 晚上好！");
        }
    }
}
