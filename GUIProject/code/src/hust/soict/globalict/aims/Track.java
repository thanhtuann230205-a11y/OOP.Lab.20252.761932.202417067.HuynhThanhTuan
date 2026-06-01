package hust.soict.globalict.aims;

import hust.soict.globalict.aims.exception.PlayerException;

public class Track extends Media implements Playable {
    private int length;

    public Track(String title, int length) {
        super(title, "Track", 0f);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() throws PlayerException {
        if (length > 0) {
            System.out.println("Playing track: " + getTitle() + " (" + length + " mins)");
        } else {
            throw new PlayerException("ERROR: Track length is non-positive!");
        }
    }
}
