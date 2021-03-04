package haui.estate.business.repositories;

import haui.estate.business.models.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<Building,String> {
}
