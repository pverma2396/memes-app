package com.crio.starter.exchange;

// import com.crio.starter.data.XMemeEntity;
import com.crio.starter.dto.XMeme;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.mongodb.lang.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class XMemeResponseDto {
    
    @NonNull
    List<XMeme> memes;

}