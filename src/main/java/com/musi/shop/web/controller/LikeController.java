package com.musi.shop.web.controller;


import com.musi.shop.web.Service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/like")
public class LikeController {

    private final LikeService likeService;

  @PostMapping("/toggle")
    public ResponseEntity<String> toggleLike(@RequestParam Long albumId, @RequestParam Long memberId) throws Exception {
      likeService.addLikeToAlbum(albumId,memberId);
      return ResponseEntity.ok("success");
  }


}
