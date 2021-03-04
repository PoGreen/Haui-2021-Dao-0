package haui.estate.business.controllers.api;


import haui.estate.business.models.bos.SystemResponse;
import haui.estate.business.models.requests.ImageRqs;
import haui.estate.business.services.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@Controller
public class ImageController {

    @Autowired
    private IImageService iImageService;

    @PostMapping(value = "/images/upload")
    public ResponseEntity<SystemResponse<Object>> loadImage(@RequestParam(value = "images") List<MultipartFile> image) throws IOException {
        return iImageService.loadImage(image);
    }
}
