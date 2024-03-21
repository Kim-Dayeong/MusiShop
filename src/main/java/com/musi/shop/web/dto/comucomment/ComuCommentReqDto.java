package com.musi.shop.web.dto.comucomment;

import com.musi.shop.web.entity.community.Community;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComuCommentReqDto {

    private Long id;
    private String content;

    private Community community;
}
