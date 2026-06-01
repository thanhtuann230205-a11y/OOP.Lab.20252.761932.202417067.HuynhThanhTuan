package hust.soict.globalict.aims;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Media> items = new ArrayList<>();

    public void addMedia(Media media) {
        if (media != null) {
            items.add(media);
        }
    }

    public List<Media> getItems() {
        return items;
    }
}
