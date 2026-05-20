package hust.soict.dsai.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() {
        if (this.getLength() > 0) {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        } else {
            System.out.println("ERROR: Track length is non-positive!");
        }
    }

    // Ghi đè equals chuẩn theo yêu cầu Bài 10
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Track)) return false;
        
        Track other = (Track) obj;
        // So sánh cả tiêu đề và độ dài
        return this.length == other.getLength() && 
               this.title != null && 
               this.title.equalsIgnoreCase(other.getTitle());
    }
}