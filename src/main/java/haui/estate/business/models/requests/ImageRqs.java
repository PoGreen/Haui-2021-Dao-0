package haui.estate.business.models.requests;

import java.util.ArrayList;
import java.util.List;

public class ImageRqs {
    private List<ImageRq> imageRqs = new ArrayList<>();

    public List<ImageRq> getImageRqs() {
        return imageRqs;
    }

    public void setImageRqs(List<ImageRq> imageRqs) {
        this.imageRqs = imageRqs;
    }
}
