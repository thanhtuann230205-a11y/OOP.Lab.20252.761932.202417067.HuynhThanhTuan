package hust.soict.globalict.aims;

import hust.soict.globalict.aims.exception.PlayerException;

public class DigitalVideoDisc extends Media implements Playable {
    private int length;

    public DigitalVideoDisc(String title, String category, float cost, int length) {
        super(title, category, cost);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() throws PlayerException {
        if (length > 0) {
            System.out.println("Playing DVD: " + getTitle() + " (" + length + " mins)");
        } else {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }
}
