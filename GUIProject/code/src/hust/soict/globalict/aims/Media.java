package hust.soict.globalict.aims;

import java.util.Objects;

public abstract class Media {
    private String title;
    private String category;
    private float cost;

    public Media(String title, String category, float cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Media cost cannot be negative.");
        }
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Media)) return false;
        Media other = (Media) o;
        return Objects.equals(title, other.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - %.2f$", title, category, cost);
    }
}
