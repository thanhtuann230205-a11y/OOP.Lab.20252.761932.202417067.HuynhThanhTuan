import javax.swing.JOptionPane;
package hust.soict.dsai.lab01;
public class bai25 {
    public static void main(String[] args){
        String m=JOptionPane.showInputDialog(null,"Nhập số a: ");
        String n=JOptionPane.showInputDialog(null,"Nhập số b: ");
        double a=Double.parseDouble(m);
        double b=Double.parseDouble(n);
        double tổng=a+b;
        double hiệu=a-b;
        double tích=a*b;
        String result="Tổng: "+tổng+" Hiệu: "+hiệu+" Tích: "+tích;
        if(b!=0){
            double thương=a/b;
            result+=" Thương: "+thương;
        }
        else{
            result+=" Thương: "+"Không xác định";
        }
        JOptionPane.showMessageDialog(null, result,"Kết quả",JOptionPane.INFORMATION_MESSAGE);
    }
}
