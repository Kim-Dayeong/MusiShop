package com.musi.shop.web.controller;


import com.musi.shop.web.Service.AlbumService;
import com.musi.shop.web.Service.HeartService;
import com.musi.shop.web.entity.Heart;
import com.nimbusds.oauth2.sdk.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationResponse.success;

@RestController
@RequiredArgsConstructor
//@RequestMapping("/api/like")
public class HeartController {

    private final HeartService heartService;



 @PostMapping("/albums/{id}")
    //좋아요 처리
    public ResponseEntity<Map<String, String>> HeartAlbumResponse(@PathVariable Long id){
     try {
         String result = heartService.HeartAlbum(id);
         //result 값 ajax에담아 보내기



         Map<String, String> response = new HashMap<>();
         response.put("status", "success");

         return ResponseEntity.ok(response);
     }catch (Exception e){
         Map<String, String> errorResponse = new HashMap<>();
         errorResponse.put("status", "error");
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
     }


 }



}
