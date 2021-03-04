package haui.estate.business.services.impls;

import haui.estate.business.models.bos.Response;
import haui.estate.business.models.bos.SystemResponse;
import haui.estate.business.models.entities.Image;
import haui.estate.business.models.requests.ImageRqs;
import haui.estate.business.models.responses.ImageRp;
import haui.estate.business.models.responses.ImageUploadRp;
import haui.estate.business.repositories.ImageRepository;
import haui.estate.business.services.IImageService;
import haui.estate.business.services.mappers.ImageMapper;
import haui.estate.business.services.validators.ImageValidator;
import haui.estate.business.utils.Global;
import haui.estate.business.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class ImageService implements IImageService {

    @Autowired
    private ImageValidator imageValidator;
    @Autowired
    private ImageMapper imageMapper;
    @Autowired
    private ImageRepository imageRepository;


    @Override
    public ResponseEntity<SystemResponse<Object>> loadImage(List<MultipartFile> images) throws IOException {
        ResponseEntity<SystemResponse<Object>> validate = imageValidator.validate(images);
        if (!validate.getStatusCode().is2xxSuccessful()) {
            return validate;
        }
        List<ImageUploadRp> imageUploadRps = new ArrayList<>();
        for (MultipartFile file : images) {
            String idImage = Util.generateUUID();
            String path = Global.PATH_FILE_IMAGE + idImage;
            try {
                file.transferTo(new File(path));
            } catch (IOException e) {
                throw new IOException(e.getMessage());
            }
            ImageUploadRp imageUploadRp = new ImageUploadRp();
            imageUploadRp.setName(idImage);
            imageUploadRp.setType(file.getContentType());
            imageUploadRps.add(imageUploadRp);
        }

        return Response.ok(imageUploadRps);
    }


    @Override
    public ResponseEntity<SystemResponse<Object>> saveImage(String idBelongs,String category,ImageRqs imageRqs) {
        ResponseEntity<SystemResponse<Object>> validate = imageValidator.validate(imageRqs);
        if (!validate.getStatusCode().is2xxSuccessful()) {
            return validate;
        }
        List<Image> images = imageMapper.mapToImage(imageRqs.getImageRqs(),idBelongs,category);
        images = imageRepository.saveAll(images);
        List<ImageRp> imageRps = imageMapper.mapToImageRp(images);
        return Response.ok(imageRps);
    }
}
