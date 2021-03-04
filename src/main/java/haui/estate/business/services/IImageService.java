package haui.estate.business.services;

import haui.estate.business.models.bos.SystemResponse;
import haui.estate.business.models.requests.ImageRqs;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IImageService {

    ResponseEntity<SystemResponse<Object>> loadImage(List<MultipartFile> images) throws IOException;

    ResponseEntity<SystemResponse<Object>> saveImage(String idBelongs,String category,ImageRqs imageRqs);

}
