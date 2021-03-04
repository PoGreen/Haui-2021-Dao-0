package haui.estate.business.services.validators;

import haui.estate.business.models.bos.Response;
import haui.estate.business.models.bos.SystemResponse;
import haui.estate.business.models.requests.ImageRq;
import haui.estate.business.models.requests.ImageRqs;
import haui.estate.business.utils.Global;
import haui.estate.business.utils.StringRp;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Component
public class ImageValidator {
    public ResponseEntity<SystemResponse<Object>> validate (List<MultipartFile> files){
        for (MultipartFile file: files) {
            String abc = file.getContentType();
            if(!file.getContentType().startsWith("image/"))
            {
                return Response.badRequest(StringRp.FILE_IS_NOT_IMAGE);
            }
        }
        return Response.ok(StringRp.SUCCESS);
    }

    public ResponseEntity<SystemResponse<Object>> validate (ImageRqs imageRqs){
        for (ImageRq imageRq : imageRqs.getImageRqs()) {
            File file = new File(Global.PATH_FILE_IMAGE + imageRq.getName());
            if(!file.exists() || !file.isFile()){
                return Response.badRequest(StringRp.FILE_IS_NOT_EXISTS);
            }
        }
        return Response.ok(StringRp.SUCCESS);
    }
}
