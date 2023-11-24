package com.musi.shop.web.web.dto;

import com.musi.shop.web.entity.Heart;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HeartDto {

    private Long id;
    private boolean status;

    public HeartDto(Heart heart) {
        this.id = heart.getId();
        this.status = heart.isStatus();
    }
}
