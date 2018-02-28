package demo.service;


import demo.model.Pet;
import demo.model.PetPicture;

public interface QueryService {

    Iterable<Pet> findsite();

    PetPicture getByMestoId(Long bookId);
}
