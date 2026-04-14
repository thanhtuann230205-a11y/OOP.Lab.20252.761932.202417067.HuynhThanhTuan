public class CartTest {
    public static void main(String[] args) {
        // 1. Khởi tạo giỏ hàng mới
        Cart cart = new Cart();

        // 2. Tạo các đối tượng DVD mẫu và thêm vào giỏ hàng
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        // 3. Kiểm tra phương thức in danh sách giỏ hàng
        System.out.println("\n--- Testing Print Method ---");
        cart.print();

        // 4. Kiểm tra các phương thức tìm kiếm
        System.out.println("\n--- Testing Search Methods ---");
        
        // Tìm kiếm theo ID (Thử với ID 1 và một ID không tồn tại)
        System.out.println("Search by ID 1:");
        cart.searchById(1);
        System.out.println("Search by ID 99:");
        cart.searchById(99);

        // Tìm kiếm theo tiêu đề (Thử với tiêu đề đúng và tiêu đề không khớp)
        System.out.println("\nSearch by Title 'Star Wars':");
        cart.searchByTitle("Star Wars");
        System.out.println("Search by Title 'Titanic':");
        cart.searchByTitle("Titanic");
    }
}