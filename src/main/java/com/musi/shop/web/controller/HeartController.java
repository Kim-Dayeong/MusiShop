package com.musi.shop.web.controller;


import com.musi.shop.web.Service.AlbumService;
import com.musi.shop.web.Service.HeartService;
import com.nimbusds.oauth2.sdk.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
//@RequestMapping("/api/like")
public class HeartController {

    private final HeartService heartService;
    private final AlbumService albumService;
 @PostMapping("/albums/{id}")
 @ResponseStatus(HttpStatus.OK)
  public Response HeartAlbum(@PathVariable int id){
   retrun Response.success(albumService.)
 }

}
