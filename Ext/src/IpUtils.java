import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpUtils {
    public static void main(String[] args) throws UnknownHostException {
        //将ipv4格式转换为long类型的数字
        String ip = "58.83.160.156";
        //字符串[58,83,160,156]
        String[] ips = ip.split("\\.");
        long num = 0;
        for (int i = 0; i < ips.length; i++) {
            num += Integer.parseInt(ips[i]) * Math.pow(256, ips.length - i - 1);
        }
        System.out.println(num);
        //将long类型数字转换为ipv4字符串
        long nn = 978559132L;
        byte[] bys = new byte[]{(byte) (nn >> 24), (byte) (nn >> 16), (byte) (nn >> 8), (byte) nn};
        System.out.println(InetAddress.getByAddress(bys).getHostAddress());
    }
}
