package imageRepo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import imageEntity.ImageEntity;


public interface ImageRepository extends JpaRepository<ImageEntity, Long> {
	Optional<ImageEntity> findByName(String filename);

}
