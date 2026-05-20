package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initData();
        int choice;
        while (true) {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1: viewStore(); break;
                case 2: updateStore(); break;
                case 3: viewCart(); break;
                case 0:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    // --- HIỂN THỊ MENU ---
    public static void showMenu() {
        System.out.println("\n--- AIMS MENU ---");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.print("Please choose a number: ");
    }

    public static void storeMenu() {
        System.out.println("\n--- STORE OPTIONS ---");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.print("Please choose a number: ");
    }

    public static void cartMenu() {
        System.out.println("\n--- CART OPTIONS ---");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.print("Please choose a number: ");
    }

    // --- LOGIC XỬ LÝ STORE ---
    private static void viewStore() {
        store.printStore();
        while (true) {
            storeMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    Media m = store.searchByTitle(title);
                    if (m != null) {
                        System.out.println(m.toString());
                        detailMenu(m);
                    } else System.out.println("Media not found.");
                    break;
                case 2:
                    System.out.print("Enter title: ");
                    String t2 = scanner.nextLine();
                    Media m2 = store.searchByTitle(t2);
                    if (m2 != null) {
                        cart.addMedia(m2);
                        System.out.println("Items in cart: " + cart.getItemsOrdered().size());
                    } else System.out.println("Media not found.");
                    break;
                case 3:
                    System.out.print("Enter title: ");
                    String t3 = scanner.nextLine();
                    Media m3 = store.searchByTitle(t3);
                    if (m3 instanceof Playable) ((Playable) m3).play();
                    else System.out.println("This media cannot be played.");
                    break;
                case 4:
                    viewCart();
                    break;
            }
        }
    }

    private static void detailMenu(Media m) {
        System.out.println("1. Add to cart | 2. Play (if applicable) | 0. Back");
        int sub = scanner.nextInt();
        scanner.nextLine();
        if (sub == 1) {
            cart.addMedia(m);
            System.out.println("Items in cart: " + cart.getItemsOrdered().size());
        } else if (sub == 2 && m instanceof Playable) ((Playable) m).play();
    }

    // --- LOGIC XỬ LÝ CART ---
    private static void viewCart() {
        cart.print();
        while (true) {
            cartMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;

            switch (choice) {
                case 1:
                    System.out.println("Filter by: 1. ID | 2. Title");
                    int fType = scanner.nextInt(); scanner.nextLine();
                    if (fType == 1) {
                        System.out.print("Enter ID: ");
                        cart.searchById(scanner.nextInt()); scanner.nextLine();
                    } else {
                        System.out.print("Enter Title: ");
                        cart.searchByTitle(scanner.nextLine());
                    }
                    break;
                case 2:
                    System.out.println("Sort by: 1. Title | 2. Cost");
                    int sType = scanner.nextInt(); scanner.nextLine();
                    if (sType == 1) cart.sortByTitle();
                    else cart.sortByCost();
                    cart.print();
                    break;
                case 3:
                    System.out.print("Enter title to remove: ");
                    String tRem = scanner.nextLine();
                    Media foundRem = null;
                    for (Media m : cart.getItemsOrdered()) {
                        if (m.getTitle().equalsIgnoreCase(tRem)) {
                            foundRem = m; break;
                        }
                    }
                    if (foundRem != null) cart.removeMedia(foundRem);
                    else System.out.println("Media not in cart.");
                    break;
                case 4:
                    System.out.print("Enter title to play: ");
                    String tPlay = scanner.nextLine();
                    Media foundPlay = null;
                    for (Media m : cart.getItemsOrdered()) {
                        if (m.getTitle().equalsIgnoreCase(tPlay)) {
                            foundPlay = m; break;
                        }
                    }
                    if (foundPlay instanceof Playable) ((Playable) foundPlay).play();
                    else System.out.println("Cannot play this media.");
                    break;
                case 5:
                    System.out.println("An order has been created. Cart is empty now.");
                    cart = new Cart(); 
                    return;
            }
        }
    }

    // --- CẬP NHẬT CỬA HÀNG (UPDATE STORE) ---
    private static void updateStore() {
        System.out.println("1. Add Media | 2. Remove Media | 0. Back");
        int sub = scanner.nextInt(); scanner.nextLine();
        if (sub == 1) {
            System.out.println("Enter type (1. DVD, 2. Book, 3. CD): ");
            int type = scanner.nextInt(); scanner.nextLine();
            System.out.print("Title: "); String title = scanner.nextLine();
            System.out.print("Category: "); String category = scanner.nextLine();
            System.out.print("Cost: "); float cost = scanner.nextFloat(); scanner.nextLine();
            
            if (type == 1) store.addMedia(new DigitalVideoDisc(title, category, "", 0, cost));
            else if (type == 2) store.addMedia(new Book(99, title, category, cost));
            else if (type == 3) store.addMedia(new CompactDisc(99, title, category, cost, "", ""));
        } else if (sub == 2) {
            System.out.print("Enter title to remove: ");
            String tRem = scanner.nextLine();
            Media m = store.searchByTitle(tRem);
            if (m != null) store.removeMedia(m);
            else System.out.println("Not found in store.");
        }
    }

    private static void initData() {
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Sci-Fi", "George Lucas", 124, 24.95f));
        store.addMedia(new Book(1, "Java Programming", "Education", 45.0f));
    }
}