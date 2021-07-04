package com.crio.starter.exchange;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// import lombok.RequiredArgsConstructor;

import com.mongodb.lang.NonNull;

// import org.springframework.beans.factory.annotation.Required;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class XMemePostRequest {

    @NonNull
    String name;

    @NonNull
    String url;

    @NonNull
    String caption;

}