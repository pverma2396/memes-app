package com.crio.starter.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mongodb.lang.NonNull;

@Data
@NoArgsConstructor
public class XMeme {
    
    @JsonIgnore
    String _id;

    @NonNull
    String id;

    @NonNull
    String name;

    @NonNull
    String url;

    @NonNull
    String caption;

}