package demo.service.impl;

import demo.model.Pet;
import demo.model.PetPicture;
import demo.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class PetServiceImpl implements PetService {


    @Autowired
    private PetServiceHelperImpl petServiceHelper;

    @Override
    public Pet createPet(String name,String description,String gender,String age,String category,String email ){


        return petServiceHelper.createPet(name,description,gender,age,category,email);
    }
    @Override
    public PetPicture addPetPicture(Integer Id, byte[] bytes, String contentType) throws SQLException {
        return petServiceHelper.addPetPicture(Id, bytes, contentType);
    }
}
