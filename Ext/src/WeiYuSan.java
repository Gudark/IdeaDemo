public class WeiYuSan {
    public static void main(String[] args) {
        int i = 21, m = 12;
        System.out.println(Integer.toBinaryString(i));//转为二进制输出
        System.out.println(0x21);//将八进制的21输出为十进制
        System.out.println(Integer.valueOf("21",8));//将21（10）转换为八进制
        System.out.println(i & m);//0011 0101  //i和m的位与运算
        String str1 = String.format("%08d",i);//将i转换为八位二进制
        String str2 = String.format("%08d",m);
        System.out.println(str1);
        System.out.println(str2);
        //System.out.println(Integer.toBinaryString());
        int n=~~2;//对2取反
        System.out.println(n);
    }
}