package demo.service;

import demo.model.Pet;
import demo.model.PetPicture;

import java.sql.SQLException;

public interface PetServiceHelper {


    Pet createPet(
            String name,
            String description,
            String gender,
            String age,
            String category,
            String email
    );

    PetPicture addPetPicture(
            Integer Id,
            byte[] bytes,
            String contentType) throws SQLException;

}
