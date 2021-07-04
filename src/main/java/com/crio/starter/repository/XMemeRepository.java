package com.crio.starter.repository;

import com.crio.starter.data.XMemeEntity;
// import com.crio.starter.dto.XMeme;

import org.springframework.data.mongodb.repository.MongoRepository;
// import org.springframework.data.mongodb.repository.Query;
// import org.springframework.data.mongodb.core.mapping.Document;


public interface XMemeRepository extends MongoRepository<XMemeEntity, String> {
    XMemeEntity findByid(int id);
    XMemeEntity findFirstByOrderByIdDesc();
}