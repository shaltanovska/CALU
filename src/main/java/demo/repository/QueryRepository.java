package demo.repository;


import demo.model.Pet;

public interface  QueryRepository {

    Iterable<Pet> findsite();
}
