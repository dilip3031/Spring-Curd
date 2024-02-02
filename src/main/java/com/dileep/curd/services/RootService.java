package com.dileep.curd.services;

import com.dileep.curd.entity.RootEntity;
import com.dileep.curd.utils.GeneralException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public class RootService {


    public RootEntity checkSaveAndUpdateRequest(RootEntity entity, JpaRepository jpaRepository) throws GeneralException {
        if (entity.getId()!=null) {
            Optional<RootEntity> entityById = jpaRepository.findById(entity.getId());
            if(entityById.isPresent()){
                if((entityById.get().getInitVersion()>entity.getInitVersion())){
                 throw new GeneralException("ERROR_001","Allready Update");
                }
                entity.setInitVersion(entity.getInitVersion()+1);
                entity= (RootEntity) jpaRepository.save(entity);
                return entity;
            }
        }
        entity.setInitVersion(0);
        entity= (RootEntity) jpaRepository.save(entity);
        return entity;
    }
}
