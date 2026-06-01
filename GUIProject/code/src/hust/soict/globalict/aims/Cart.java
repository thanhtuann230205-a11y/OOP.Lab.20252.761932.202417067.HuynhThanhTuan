package hust.soict.globalict.aims;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public void addMedia(Media media) {
        if (media == null) {
            return;
        }
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            throw new IllegalStateException("The cart is full.");
        }
        itemsOrdered.add(media);
    }

    public void removeMedia(Media media) {
        if (!itemsOrdered.remove(media)) {
            throw new IllegalArgumentException("The media is not in the cart.");
        }
    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public float totalCost() {
        return (float) itemsOrdered.stream().mapToDouble(Media::getCost).sum();
    }
}
