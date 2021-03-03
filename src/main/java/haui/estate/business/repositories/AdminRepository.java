package haui.estate.business.repositories;

import haui.estate.business.models.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,String> {
    boolean existsByAdminNameAndStatus(String name, int status);
}
