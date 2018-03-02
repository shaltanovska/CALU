package demo.service.impl;

import demo.model.FileEmbeddable;
import demo.model.Pet;
import demo.model.PetPicture;
import demo.repository.PetPictureRepository;
import demo.repository.PetRepository;
import demo.service.PetServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.SQLException;

@Service
public class PetServiceHelperImpl  implements PetServiceHelper{



    private PetRepository petRepository;
    private PetPictureRepository petPictureRepository;

    @Autowired
    public PetServiceHelperImpl( PetRepository petRepository , PetPictureRepository petPictureRepository) {

        this.petRepository = petRepository;
        this.petPictureRepository=petPictureRepository;


    }


    @Override
    public Pet createPet(String name,String description,String gender,String age,String category,String email ){

        Pet pet=new Pet();
        pet.name=name;
        pet.description=description;
        pet.gender=gender;
        pet.age=age;
        pet.category=category;
        pet.email=email;

        return petRepository.save(pet);
    }

    @Override
    public PetPicture addPetPicture(Integer Id, byte[] bytes, String contentType) throws SQLException {
        PetPicture mestoPicture = new PetPicture();
        mestoPicture.pet = petRepository.findOne(Id);
        FileEmbeddable picture = new FileEmbeddable();
        picture.contentType = contentType;
        picture.data = new SerialBlob(bytes);
        picture.size = bytes.length;
        picture.fileName = mestoPicture.pet.name;
        mestoPicture.picture = picture;
        return petPictureRepository.save(mestoPicture);
    }

}
