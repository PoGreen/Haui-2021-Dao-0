package haui.estate.business.repositories;


import haui.estate.business.models.entities.BuildingCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuildingCategoryRepository extends JpaRepository<BuildingCategory, String> {
    boolean existsByName(String name);
    List<BuildingCategory> findByStatus(int status);

}
