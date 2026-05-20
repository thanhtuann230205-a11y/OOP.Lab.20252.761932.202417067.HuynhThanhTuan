package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    
    private static int nbDigitalVideoDiscs = 0;

    // Constructor 1: Chỉ có tiêu đề
    public DigitalVideoDisc(String title) {
        // Phải truyền ID vào super() vì setId() đã bị xóa ở lớp Media
        super(++nbDigitalVideoDiscs, title, null, 0.0f, 0, null);
    }

    // Constructor 2: Đầy đủ các thuộc tính
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, length, director);
    }

    // Constructor 3: Các biến thể cũ
    public DigitalVideoDisc(String category, String title, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, 0, null);
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, 0, director);
    }

    // Cài đặt phương thức play() từ interface Playable
    @Override
    public void play() {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            System.out.println("ERROR: DVD length is 0 or negative!");
        }
    }

    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": " + getCost() + " $";
    }
}