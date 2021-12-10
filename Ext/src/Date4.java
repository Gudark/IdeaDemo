public class Date4 {
    public static void main(String[] args) {

        //工具栏Run->Edit Configurations->Program arguments 对args[]字符串组赋值
        //args[0]运行java程序时传入的第一个参数;
        int a = Integer.parseInt(args[0]);
        //Integer.parseInt(args[])就是将args参数转换为整型
        int b = Integer.parseInt(args[1]);

        System.err.println("hello");

        //格式化输出a+b=(a+b)
        System.out.printf("%d + %d = %d%n", a, b, a + b);
        //输出a+b运算
        System.out.println(a + "+" + b + "=" + (a + b));

        String name = "李四";
        int age = 5;
        String addr = "中国北京市王府井大街99号";
        double money = 1000.98;
        System.out.println("姓名：" + name + ",年龄：0" + age + "岁，金额：" + money + "元，家庭地址：" + addr + "。");
        System.out.printf("姓名：%s，年龄：%02d岁，金额：%.1f元，家庭地址：%s。%n", name, age, money, addr);

        //格式化输出为十六进制
        System.out.printf("#%02x%02x%02x", 255, 0, 0);//#ff0000

        long time = System.currentTimeMillis();
        //输出年月日 时分秒24
        System.out.printf("%n%1$tF %1$tT\n", time);

        //java系统启动时通过Locale.getDefault()可得到当前应用默认Locale信息
        //若希望应用不论部署在任何机器上，皆可保持同一个默认Locale
        //Locale.setDefault(Locale.US);
        System.out.printf("%1$tY年%1$tm月%1$td日 %1$tT %1$tA\n", time);
        System.out.printf("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS.jpg", time);
    }
}
