public class Store {
    private DigitalVideoDisc itemsInStore[];
    private int qtyInStore = 0;
    private static final int MAX_CAPACITY = 100;
    public Store() {
        itemsInStore = new DigitalVideoDisc[MAX_CAPACITY];
    }
    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < MAX_CAPACITY) {
            itemsInStore[qtyInStore] = dvd;
            qtyInStore++;
            System.out.println("DVD '" + dvd.getTitle() + "' đã được thêm vào kho.");
        } else {
            System.out.println("Kho hàng đã đầy, không thể thêm đĩa!");
        }
    }
    public void removeDVD(DigitalVideoDisc dvd) {
        boolean found = false;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == dvd) {
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null;
                qtyInStore--;
                found = true;
                System.out.println("DVD '" + dvd.getTitle() + "' đã được xóa khỏi kho.");
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy DVD này trong kho để xóa!");
        }
    }
}