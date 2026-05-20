package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        // 1. Khởi tạo giỏ hàng
        Cart cart = new Cart();

        // 2. Tạo các đối tượng DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);

        // 3. Thêm DVD vào giỏ hàng (Sử dụng addMedia thay cho addDigitalVideoDisc)
        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);

        // 4. Thử thêm một cuốn sách (Minh chứng cho tính Đa hình của Bài 7)
        Book book1 = new Book(4, "Java Programming", "Education", 50.0f);
        cart.addMedia(book1);

        // 5. Kiểm tra phương thức in giỏ hàng
        System.out.println("\n--- Testing Print Method ---");
        cart.print();

        // 6. Kiểm tra các phương thức tìm kiếm
        System.out.println("\n--- Testing Search Methods ---");
        
        System.out.println("Search by ID 1:");
        cart.searchById(1);
        
        System.out.println("Search by ID 99:");
        cart.searchById(99);

        System.out.println("\nSearch by Title 'Star Wars':");
        cart.searchByTitle("Star Wars");
        
        System.out.println("Search by Title 'Titanic':");
        cart.searchByTitle("Titanic");
    }
}