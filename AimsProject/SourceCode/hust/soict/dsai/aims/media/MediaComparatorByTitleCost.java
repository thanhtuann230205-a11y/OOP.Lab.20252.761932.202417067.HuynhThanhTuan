package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // So sánh theo tiêu đề (không phân biệt hoa thường)
        int titleDiff = m1.getTitle().compareToIgnoreCase(m2.getTitle());
        
        // Nếu tiêu đề khác nhau, trả về kết quả so sánh tiêu đề
        if (titleDiff != 0) {
            return titleDiff;
        }
        
        // Nếu tiêu đề giống nhau, so sánh theo giá (Giá cao hơn đứng trước - Giảm dần)
        return Float.compare(m2.getCost(), m1.getCost());
    }
}