package haui.estate.business.services.mappers;

import haui.estate.business.models.entities.BuildingCategory;
import haui.estate.business.models.requests.BuildingCInsertRq;
import haui.estate.business.models.requests.BuildingCUpdateRq;
import haui.estate.business.models.responses.BuildingCategoryRp;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BuildingCategoryMapper {

    public BuildingCategoryRp map(BuildingCategory buildingCategory){
        BuildingCategoryRp buildingCategoryRp = new BuildingCategoryRp();
        buildingCategoryRp.setId(buildingCategory.getId());
        buildingCategoryRp.setName(buildingCategory.getName());
        buildingCategoryRp.setDescription(buildingCategory.getDescription());
        buildingCategoryRp.setBuildingCategory(buildingCategory.getBuildingCategory());
        return buildingCategoryRp;
    }

    public List<BuildingCategoryRp>  map(List<BuildingCategory> buildingCategories){
        return buildingCategories.stream().map(bc -> map(bc)).collect(Collectors.toList());
    }

    public BuildingCategory map(BuildingCategory buildingCategory,BuildingCInsertRq buildingCInsertRq){
        buildingCategory.setName(buildingCInsertRq.getName());
        buildingCategory.setDescription(buildingCInsertRq.getDescription());
        buildingCategory.setBuildingCategory(buildingCInsertRq.getBuildingCategory());
        return buildingCategory;
    }
    public BuildingCategory map(BuildingCategory buildingCategory, BuildingCUpdateRq buildingCUpdateRq){
        buildingCategory.setName(buildingCUpdateRq.getName());
        buildingCategory.setDescription(buildingCUpdateRq.getDescription());
        buildingCategory.setBuildingCategory(buildingCUpdateRq.getBuildingCategory());
        buildingCategory.setStatus(buildingCUpdateRq.getStatus());
        return buildingCategory;
    }
}
