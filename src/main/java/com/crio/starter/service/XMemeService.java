package com.crio.starter.service;

// import io.lettuce.core.dynamic.annotation.Param;
// import lombok.RequiredArgsConstructor;

// import java.util.ArrayList;
import java.util.List;

import com.crio.starter.dto.XMeme;
import com.crio.starter.exchange.XMemePostRequest;
// import com.crio.starter.exchange.XMemeResponseDto;
// import com.crio.starter.exchange.postMemeResponse;
// import com.crio.starter.repository.XMemeRepository;

// import org.springframework.stereotype.Service;

public interface XMemeService {

    // @param XMemeResponseDto
    // @return
    
    List<XMeme> getMemes ();

    XMeme getParticular (int id);

	String saveMeme(XMemePostRequest xMemePostRequest);
    
}