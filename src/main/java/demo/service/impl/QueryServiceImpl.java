package demo.service.impl;

import demo.model.Pet;
import demo.repository.QueryRepository;
import demo.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryServiceImpl implements QueryService {


    QueryRepository queryRepository;

    @Autowired
    public QueryServiceImpl(QueryRepository queryRepository) {

        this.queryRepository = queryRepository;

    }


    @Override
    public Iterable<Pet> findsite(){

        return queryRepository.findsite();

    }
}
