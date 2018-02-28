package demo.service.impl;

import demo.model.Pet;
import demo.model.PetPicture;
import demo.repository.PetPictureRepository;
import demo.repository.QueryRepository;
import demo.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryServiceImpl implements QueryService {


    QueryRepository queryRepository;

    PetPictureRepository petPictureRepository;

    @Autowired
    public QueryServiceImpl(QueryRepository queryRepository,PetPictureRepository petPictureRepository) {

        this.queryRepository = queryRepository;
        this.petPictureRepository=petPictureRepository;

    }


    @Override
    public  Iterable<Pet> findsite(){

        return queryRepository.findsite();

    }

    @Override
    public PetPicture getByMestoId(Long Id) {
        return petPictureRepository.findById(Id);
    }
}
