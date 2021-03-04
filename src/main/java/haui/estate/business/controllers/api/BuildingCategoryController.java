package haui.estate.business.controllers.api;

import haui.estate.business.models.bos.SystemResponse;
import haui.estate.business.models.requests.BuildingCInsertRq;
import haui.estate.business.models.requests.BuildingCUpdateRq;
import haui.estate.business.models.requests.DeleteRq;
import haui.estate.business.services.IBuildingCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller(value = "building-categories")
public class BuildingCategoryController {

    @Autowired
    private IBuildingCategoryService iBuildingCategoryService;

    @GetMapping(value = "/building-categories/pages")
    public String getAllBuildingCategoryPage(){
        return "building-category";
    }

    @GetMapping(value = "/building-categories")
    public ResponseEntity<SystemResponse<Object>> getBuildingCategoryStatus(@RequestParam(value = "status")String status){
        return iBuildingCategoryService.getBuildingCategoryByStatus(status);
    }
    @PostMapping(value = "/building-categories")
    public ResponseEntity<SystemResponse<Object>> addOne(@RequestBody BuildingCInsertRq buildingCInsertRq){
        return iBuildingCategoryService.addOne(buildingCInsertRq);
    }

    @PutMapping(value = "/building-categories")
    public ResponseEntity<SystemResponse<Object>> update(@RequestBody BuildingCUpdateRq buildingCUpdateRq){
        return iBuildingCategoryService.updateOne(buildingCUpdateRq);
    }

    @DeleteMapping(value = "/building-categories")
    public ResponseEntity<SystemResponse<Object>> delOne(@RequestBody DeleteRq deleteRq){
        return iBuildingCategoryService.delOne(deleteRq);
    }
}
