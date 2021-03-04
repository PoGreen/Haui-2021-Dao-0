package haui.estate.business.services.impls;

import haui.estate.business.models.bos.Response;
import haui.estate.business.models.bos.Status;
import haui.estate.business.models.bos.SystemResponse;
import haui.estate.business.models.entities.BuildingCategory;
import haui.estate.business.models.requests.BuildingCInsertRq;
import haui.estate.business.models.requests.BuildingCUpdateRq;
import haui.estate.business.models.requests.DeleteRq;
import haui.estate.business.models.responses.BuildingCategoryRp;
import haui.estate.business.repositories.BuildingCategoryRepository;
import haui.estate.business.services.IBuildingCategoryService;
import haui.estate.business.services.mappers.BuildingCategoryMapper;
import haui.estate.business.utils.Global;
import haui.estate.business.utils.StringRp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BuildingCategoryService implements IBuildingCategoryService {
    @Autowired
    private BuildingCategoryRepository buildingCategoryRepository;

    @Autowired
    private BuildingCategoryMapper buildingCategoryMapper;

    @Override
    public ResponseEntity<SystemResponse<Object>> getBuildingCategoryByStatus(String status) {
        List<BuildingCategory> buildingCategories;
        Status staus = Status.valueOf(status);
        switch (staus) {
            case all: {
                buildingCategories = buildingCategoryRepository.findAll();
                break;
            }
            case active: {
                buildingCategories = buildingCategoryRepository.findByStatus(Global.ACTIVE);
                break;
            }
            default: {
                buildingCategories = buildingCategoryRepository.findByStatus(Global.DELETE);
                break;
            }
        }
        List<BuildingCategoryRp> buildingCategoryRps = buildingCategoryMapper.map(buildingCategories);
        return Response.ok(buildingCategoryRps);
    }

    @Override
    public ResponseEntity<SystemResponse<Object>> addOne(BuildingCInsertRq buildingCInsertRq) {
        if (buildingCInsertRq.getBuildingCategory() != null) {
            BuildingCategory buildingCategory =
                    buildingCategoryRepository.findById(buildingCInsertRq
                            .getBuildingCategory()).orElse(null);
            if (Objects.isNull(buildingCategory)) {
                return Response.badRequest(StringRp.BUILDING_CATEGORY_IS_FAKE);
            }
        }

        boolean exits = buildingCategoryRepository.existsByName(buildingCInsertRq.getName());
        if (exits) {
            return Response.badRequest(StringRp.NAME_IS_EXISTS);
        }
        BuildingCategory buildingCategory = new BuildingCategory();
        buildingCategory = buildingCategoryMapper.map(buildingCategory, buildingCInsertRq);
        buildingCategory = buildingCategoryRepository.save(buildingCategory);
        BuildingCategoryRp buildingCategoryRp = buildingCategoryMapper.map(buildingCategory);

        return Response.ok(buildingCategoryRp);
    }

    @Override
    public ResponseEntity<SystemResponse<Object>> updateOne(BuildingCUpdateRq buildingCUpdateRq) {
        BuildingCategory buildingCategoryOld = buildingCategoryRepository.findById(buildingCUpdateRq.getId()).orElse(null);
        if (Objects.isNull(buildingCategoryOld)) {
            return Response.badRequest(StringRp.BUILDING_CATEGORY_IS_FAKE);
        }
        if (buildingCUpdateRq.getBuildingCategory() != null) {
            BuildingCategory buildingCategory =
                    buildingCategoryRepository.findById(buildingCUpdateRq
                            .getBuildingCategory()).orElse(null);
            if (Objects.isNull(buildingCategory)) {
                return Response.badRequest(StringRp.BUILDING_CATEGORY_IS_FAKE);
            }
        }
        if (!buildingCategoryOld.getName().equals(buildingCUpdateRq.getName())) {
            boolean exits = buildingCategoryRepository.existsByName(buildingCUpdateRq.getName());
            if (exits) {
                return Response.badRequest(StringRp.NAME_IS_EXISTS);
            }
        }
        buildingCategoryOld = buildingCategoryMapper.map(buildingCategoryOld, buildingCUpdateRq);
        buildingCategoryOld = buildingCategoryRepository.save(buildingCategoryOld);
        BuildingCategoryRp buildingCategoryRp = buildingCategoryMapper.map(buildingCategoryOld);

        return Response.ok(buildingCategoryRp);
    }

    @Override
    public ResponseEntity<SystemResponse<Object>> delOne(DeleteRq deleteRq) {
        BuildingCategory buildingCategory = buildingCategoryRepository.findById(deleteRq.getId()).orElse(null);
        if (Objects.isNull(buildingCategory)) {
            return Response.badRequest(StringRp.BUILDING_CATEGORY_IS_FAKE);
        }
        buildingCategory.setStatus(0);
        buildingCategoryRepository.save(buildingCategory);
        return Response.ok(StringRp.SUCCESS);
    }

}
