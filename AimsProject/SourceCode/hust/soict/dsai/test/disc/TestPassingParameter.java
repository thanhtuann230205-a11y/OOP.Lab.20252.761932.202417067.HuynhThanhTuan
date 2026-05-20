package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        // Đổi addDigitalVideoDisc thành addMedia
        anOrder.addMedia(dvd1);
        anOrder.addMedia(dvd2);
        anOrder.addMedia(dvd3);

        System.out.println("Total Cost is: " + anOrder.totalCost());

        // Đổi removeDigitalVideoDisc thành removeMedia
        anOrder.removeMedia(dvd1); 
        System.out.println("Total Cost after removing 'The Lion King': " + anOrder.totalCost());
        
        System.out.println("--------------------------------------------");

        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        System.out.println("Before swap: " + jungleDVD.getTitle() + " / " + cinderellaDVD.getTitle());
        swap(jungleDVD, cinderellaDVD);
        System.out.println("After swap: " + jungleDVD.getTitle() + " / " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("After changeTitle: " + jungleDVD.getTitle());
    }

    // Hàm swap đã được sửa để hoán đổi nội dung (tiêu đề) bên trong đối tượng
    public static void swap(Object o1, Object o2) {
        if (o1 instanceof DigitalVideoDisc && o2 instanceof DigitalVideoDisc) {
            DigitalVideoDisc d1 = (DigitalVideoDisc) o1;
            DigitalVideoDisc d2 = (DigitalVideoDisc) o2;
            
            String tmpTitle = d1.getTitle();
            d1.setTitle(d2.getTitle());
            d2.setTitle(tmpTitle);
        }
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        // Dòng này không có tác dụng bên ngoài vì 'dvd' là biến địa phương
        dvd = new DigitalVideoDisc(oldTitle);
    }
}