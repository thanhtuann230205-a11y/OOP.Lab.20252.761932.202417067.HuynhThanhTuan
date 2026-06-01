package hust.soict.globalict.aims;

import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.screen.StoreScreen;

public class Aims {
    public static void main(String[] args) {
        Store store = new Store();
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", 19.95f, 87));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f, 124));
        store.addMedia(new DigitalVideoDisc("Aladdin", "Animation", 18.99f, 90));
        Book book = new Book("Effective Java", "Programming", 45.50f);
        book.addAuthor("Joshua Bloch");
        store.addMedia(book);
        CompactDisc cd = new CompactDisc("Best of Pop", "Music", 12.99f, "Various Artists");
        cd.addTrack(new Track("Opening Song", 4));
        store.addMedia(cd);

        Cart cart = new Cart();
        cart.addMedia(new DigitalVideoDisc("The Lion King", "Animation", 19.95f, 87));

        try {
            cart.getItemsOrdered().forEach(media -> {
                if (media instanceof Playable) {
                    try {
                        ((Playable) media).play();
                    } catch (PlayerException e) {
                        System.err.println(e.getMessage());
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            System.err.println("Error during playback: " + e.getMessage());
            e.printStackTrace();
        }

        new StoreScreen(store, cart);
    }
}
