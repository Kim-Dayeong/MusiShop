package com.musi.shop.web.controller;


import com.musi.shop.web.Service.HeartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/like")
public class HeartController {

    private final HeartService heartService;

  @PostMapping("/toggle")
    public ResponseEntity<String> toggleLike(@RequestParam Long albumId, @RequestParam Long memberId) throws Exception {
      heartService.addLikeToAlbum(albumId,memberId);
      return ResponseEntity.ok("success");
  }


}
