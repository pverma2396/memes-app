package com.crio.starter.controller;

import com.crio.starter.dto.XMeme;
import com.crio.starter.exchange.XMemePostRequest;
// import com.crio.starter.exchange.XMemeResponseDto;
import com.crio.starter.exchange.postMemeResponse;
import com.crio.starter.service.XMemeService;

// import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class XmemeController {

    // private XMemeResponseDto xmemeresponsedto;

    @Autowired
    private XMemeService xmemeService;

    @RequestMapping(value = "/memes", method = RequestMethod.GET)
    public ResponseEntity<List<XMeme>> getMemes () {
        List<XMeme> memeresponse = null;

        memeresponse = xmemeService.getMemes();
        // xmemeresponsedto = xmemeService.getMemes();

        return ResponseEntity.status(200).body(memeresponse);

    }

    @RequestMapping(value = "/memes/{id}", method = RequestMethod.GET)
    public ResponseEntity<XMeme> getParticular (@PathVariable("id") int id) {

        XMeme responseMeme = xmemeService.getParticular(id);

        if (responseMeme.getId() == null) {
            return ResponseEntity.status(404).body(null);
        }

        return ResponseEntity.status(200).body(responseMeme);
    }

    @RequestMapping(value = "/memes", method = RequestMethod.POST)
    public ResponseEntity<postMemeResponse> postMeme (@RequestBody XMemePostRequest xMemePostRequest) {

        if (xMemePostRequest.getName() == null || xMemePostRequest.getUrl() == null || xMemePostRequest.getCaption() == null) {
            return ResponseEntity.status(400).body(null);
        }

        String id = xmemeService.saveMeme(xMemePostRequest);
        postMemeResponse response = new postMemeResponse();

        switch (id) {
            case "empty fields":
                return ResponseEntity.status(400).body(null);

            case "already exists":
                return ResponseEntity.status(409).body(null);
        }
            
        response.setId(id);

        return ResponseEntity.status(200).body(response);
    }


}