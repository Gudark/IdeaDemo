import java.util.Date;//精确导入类
public class Date1 {
    public static void main(String[] args){
        Date d = new Date();
        //2021-12-09 11:02:04 周四 12月 09 11:02:04 CST 2021
        System.out.printf("%tF %tT %tc",d,d,d);
        //等价于上方输出，$表示多次被使用参数，1表示参数位置（格式化位于0位）
        System.out.printf("%tF %1$tT %1$tc\n",d);
    }
}
