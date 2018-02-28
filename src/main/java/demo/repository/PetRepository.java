package demo.repository;

import demo.model.Pet;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Aleksandar on 21.06.2017.
 */
public interface PetRepository extends CrudRepository<Pet, Long>,
        JpaSpecificationExecutor<Pet> {

    Pet save(Pet tmesto);


}
