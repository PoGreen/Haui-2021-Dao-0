package haui.estate.business.services;

import haui.estate.business.models.bos.SystemResponse;
import haui.estate.business.models.requests.BuildingCInsertRq;
import haui.estate.business.models.requests.BuildingCUpdateRq;
import haui.estate.business.models.requests.DeleteRq;
import org.springframework.http.ResponseEntity;

public interface IBuildingCategoryService {
    ResponseEntity<SystemResponse<Object>> getBuildingCategoryByStatus(String status);
    ResponseEntity<SystemResponse<Object>> addOne(BuildingCInsertRq buildingCInsertRq);

    ResponseEntity<SystemResponse<Object>> updateOne(BuildingCUpdateRq buildingCUpdateRq);
    ResponseEntity<SystemResponse<Object>> delOne(DeleteRq deleteRq);
}
