package haui.estate.business.services.mappers;

import haui.estate.business.models.entities.Building;
import haui.estate.business.models.entities.Image;
import haui.estate.business.models.requests.ImageRq;
import haui.estate.business.models.responses.ImageRp;
import haui.estate.business.models.responses.ImageUploadRp;
import haui.estate.business.repositories.BuildingRepository;
import haui.estate.business.repositories.CustomerRepository;
import haui.estate.business.repositories.NewsRepository;
import haui.estate.business.utils.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ImageMapper {

    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private BuildingRepository buildingRepository;
    public List<Image> mapToImage(List<ImageRq> imageRqs, String id, String category) {
;        Building building = buildingRepository.findById(id).orElse(null);
        return imageRqs.stream().map(imageRq -> {
            Image image = new Image();
            if(category.equals(Global.BUILDINGS)){
                image.setBuilding(buildingRepository.findById(id).orElse(null));
            }
            if(category.equals(Global.NEWS)){
                image.setNews(newsRepository.findById(id).orElse(null));
            }
            image.setName(imageRq.getName());
            image.setType(imageRq.getType());
            return image;
        }).collect(Collectors.toList());
    }

    public List<ImageRp> mapToImageRp(List<Image> images) {
        return images.stream().map(image -> {
            return mapToImageRp(image);
        }).collect(Collectors.toList());
    }

    public ImageRp mapToImageRp(Image image) {
        ImageRp imageRp = new ImageRp();
        imageRp.setName(image.getName());
        imageRp.setType(image.getType());
        imageRp.setUrl(Global.DOMAIN_PATH_FILE_IMAGE + image.getName());
        return imageRp;
    }
    public ImageUploadRp mapToImageUploadRp(Image image) {
        ImageUploadRp imageUploadRp = new ImageUploadRp();
        imageUploadRp.setName(image.getName());
        imageUploadRp.setType(image.getType());
        return imageUploadRp;
    }
}
