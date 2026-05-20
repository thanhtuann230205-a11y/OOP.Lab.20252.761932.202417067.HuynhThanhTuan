package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        // 1. Khởi tạo cửa hàng
        Store myStore = new Store();

        // 2. Tạo các đối tượng DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        // 3. Thêm sản phẩm vào cửa hàng (Đổi sang addMedia)
        System.out.println("--- Adding items to store ---");
        myStore.addMedia(dvd1);
        myStore.addMedia(dvd2);
        myStore.addMedia(dvd3);
        
        // Hiển thị trạng thái cửa hàng
        myStore.printStore();

        // 4. Xóa sản phẩm khỏi cửa hàng (Đổi sang removeMedia)
        System.out.println("\n--- Removing items from store ---");
        myStore.removeMedia(dvd2); // Xóa lần 1: Thành công
        myStore.removeMedia(dvd2); // Xóa lần 2: Sẽ báo không tìm thấy (vì đã xóa rồi)

        // 5. Kiểm tra kết quả cuối cùng
        System.out.println("\n--- Final store state ---");
        myStore.printStore();
    }
}