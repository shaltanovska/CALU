package demo.repository.impl;

import demo.model.Pet;
import demo.repository.QueryRepository;
import demo.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QueryRepositoryImpl  implements QueryRepository {


    PetRepository mestoRepository;

    @Autowired
    public QueryRepositoryImpl(PetRepository bookRepository) {

        this.mestoRepository = bookRepository;
    }



    @Override
    public  Iterable<Pet> findsite(){

        return mestoRepository.findAll();
    }
 }
