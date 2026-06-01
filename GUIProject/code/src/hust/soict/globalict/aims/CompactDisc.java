package hust.soict.globalict.aims;

import hust.soict.globalict.aims.exception.PlayerException;
import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Media implements Playable {
    private List<Track> tracks = new ArrayList<>();
    private String artist;

    public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public CompactDisc(String title, String category, float cost, String artist) {
        super(title, category, cost);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (track != null) {
            tracks.add(track);
        }
    }

    public int getLength() {
        return tracks.stream().mapToInt(Track::getLength).sum();
    }

    @Override
    public void play() throws PlayerException {
        int length = getLength();
        if (length <= 0) {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
        System.out.println("Playing CD: " + getTitle() + " (" + length + " mins)");
        for (Track track : tracks) {
            try {
                track.play();
            } catch (PlayerException e) {
                throw e;
            }
        }
    }
}
