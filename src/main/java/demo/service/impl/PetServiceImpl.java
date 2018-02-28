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
    private PetServiceHelperImpl mestaServiceHelper;

    @Override
    public Pet createPet(String name,String description,String sex,String age,String category ){


        return mestaServiceHelper.createPet(name,description,sex,age,category);
    }
    @Override
    public PetPicture addPetPicture(int Id, byte[] bytes, String contentType) throws SQLException {
        return mestaServiceHelper.addPetPicture(Id, bytes, contentType);
    }
}
