package haui.estate.business.repositories;

import haui.estate.business.models.entities.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, String> {
}
