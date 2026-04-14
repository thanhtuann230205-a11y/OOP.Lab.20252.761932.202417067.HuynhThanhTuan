public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED]; 
    private int qtyOrdered = 0;
    public int getQtyOrdered() { 
        return qtyOrdered;
    }
    public void addDigitalVideoDisc(DigitalVideoDisc disc) { 
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        } else {
            System.out.println("The cart is almost full"); 
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                this.addDigitalVideoDisc(disc);
            } else {
                System.out.println("The cart is almost full");
                break;
            }
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
        for (DigitalVideoDisc disc : dvds) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                this.addDigitalVideoDisc(disc);
            } else {
                System.out.println("The cart is almost full");
                break;
            }
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered + 2 <= MAX_NUMBERS_ORDERED) {
            this.addDigitalVideoDisc(dvd1);
            this.addDigitalVideoDisc(dvd2);
        } else {
            System.out.println("The cart is almost full, cannot add both discs");
        }
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) { 
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The disc has been removed");
                return;
            }
        }
        System.out.println("The disc was not found in the cart");
    }
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
}