package haui.estate.business.repositories;

import haui.estate.business.models.entities.Ward;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WardRepository extends JpaRepository<Ward,Integer> {
    List<Ward> findByDistrict_Id(int districtId);
}
