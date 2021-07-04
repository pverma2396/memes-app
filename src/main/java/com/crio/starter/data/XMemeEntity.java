package com.crio.starter.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIgnore;
// import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.lang.NonNull;

// import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@Document(collection = "greetings")
public class XMemeEntity {
    
    @NonNull
    @JsonIgnore
    @Field("_id")
    private String _id;

    @NonNull
    @Field("id")
    private int id;

    @NonNull
    private String name;

    @NonNull
    private String url;

    @NonNull
    private String caption;

}