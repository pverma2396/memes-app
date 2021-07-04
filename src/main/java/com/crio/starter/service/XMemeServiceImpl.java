package com.crio.starter.service;

import com.crio.starter.exchange.XMemePostRequest;
// import com.crio.starter.exchange.XMemeResponseDto;
// import com.crio.starter.exchange.postMemeResponse;
import com.crio.starter.repository.XMemeRepository;

// import java.security.Provider;
import java.util.ArrayList;
// import java.util.Collections;
import java.util.List;
// import java.util.Optional;

// import com.crio.starter.controller.XmemeController;
import com.crio.starter.data.XMemeEntity;
import com.crio.starter.dto.XMeme;

// import com.fasterxml.jackson.core.JsonProcessingException;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.mysql.cj.x.protobuf.MysqlxCrud.Limit;
// import com.fasterxml.jackson.core.type.TypeReference;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
// import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class XMemeServiceImpl implements XMemeService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private XMemeRepository xmemerepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<XMeme> getMemes() {

        List<XMeme> memes = new ArrayList<XMeme>();
        List<XMemeEntity> memesEntity = new ArrayList<XMemeEntity>();

        Query query2 = new Query();
        query2.with(Sort.by(Sort.Direction.DESC, "id"));
        query2.limit(100);

        memesEntity = mongoTemplate.find(query2, XMemeEntity.class);
        
        // memesEntity = xmemerepository.findAll();
        // System.out.println(memesEntity);

        for (XMemeEntity xe : memesEntity) {
            XMeme xmeme = modelMapper.map(xe, XMeme.class);
            System.out.println(xmeme);
            memes.add(xmeme);
        }

        // System.out.println(memes);

        return memes;
    }

    @Override
    public XMeme getParticular(int id) {

        XMeme meme = new XMeme();

        XMemeEntity xe = xmemerepository.findByid(id);

        if (xe != null) {
            meme = modelMapper.map(xe, XMeme.class);
        }

        return meme;
    }

    @Override
    public String saveMeme(XMemePostRequest xMemePostRequest) {
        XMemeEntity xe = modelMapper.map(xMemePostRequest, XMemeEntity.class);

        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(xMemePostRequest.getName()));
        query.addCriteria(Criteria.where("url").is(xMemePostRequest.getUrl()));
        query.addCriteria(Criteria.where("caption").is(xMemePostRequest.getCaption()));

        if (mongoTemplate.exists(query, XMemeEntity.class)) {
            return "already exists";
        }

        xe.setId(1);

        Query query2 = new Query();
        query2.with(Sort.by(Sort.Direction.DESC, "id"));
        query2.limit(1);


        XMemeEntity xeLast = mongoTemplate.findOne(query2, XMemeEntity.class);
        
        if (xeLast != null) {
            int id = xeLast.getId();
            id++;
            xe.setId(id);
        }

        mongoTemplate.insert(xe);

        return String.valueOf(xe.getId());
    }


}