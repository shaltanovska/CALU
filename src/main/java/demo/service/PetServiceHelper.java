package demo.service;

import demo.model.Pet;
import demo.model.PetPicture;

import java.sql.SQLException;

public interface PetServiceHelper {


    Pet createPet(
            String name,
            String description,
            String sex,
            String age,
            String category
    );

    PetPicture addPetPicture(
            int Id,
            byte[] bytes,
            String contentType) throws SQLException;

}
