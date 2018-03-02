package demo.repository;

import demo.model.PetPicture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Aleksandar on 21.06.2017.
 */
@Repository
public interface PetPictureRepository extends CrudRepository<PetPicture, Integer> {

  PetPicture findById(Integer id);
}
