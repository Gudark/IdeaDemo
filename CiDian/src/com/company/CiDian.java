import org.jsoup.Jsoup;
import javax.swing.*;
import java.io.IOException;

public class CiDian {
    public static void main(String[] args)  throws IOException {
    String w = JOptionPane.showInputDialog("请输入词汇:");
    String u = "http://youdao.com/w/eng/"+w+"/#keyform=dict2.index";
    String o = Jsoup.connect(u).get().select("div[class=trans-container]").get(0).text();
    JOptionPane.showMessageDialog(null,o);
    }
}
