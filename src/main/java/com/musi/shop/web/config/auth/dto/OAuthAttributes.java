package com.musi.shop.web.config.auth.dto;

import com.musi.shop.web.entity.Member;
import com.musi.shop.web.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String username;
    private String nickname;
    private String email;
    private String picture;
    private String provider;
    private Role role;

//    @Builder
//    public OAuthAttributes(Map<String, Object> attributes,String nameAttributeKey
//            ,String nickname,String email,String picture, String provider){
//        this.attributes = attributes;
//        this.nameAttributeKey = nameAttributeKey;
//        this.nickname = nickname;
//        this.email = email;
//        this.picture = picture;
//        this.provider = provider;
//
//    }


    public static OAuthAttributes of(String regirationId,
                                     String userNameAttributeName,
                                     Map<String, Object> attributes){
        return ofGoole(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofGoole(String userNameAttributeName,
                                           Map<String, Object>attributes){
        return OAuthAttributes.builder()
                .username((String) attributes.get("email"))
                .email((String) attributes.get("email"))
                .nickname((String) attributes.get("name"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public Member toEntity(){
        return Member.builder()
                .username(email)
                .email(email)
                .nickname(nickname)
                .role(Role.USER)
                .build();
    }

//    public static OAuthAttributes of(String registrationId,String userNameAttributeName,
//                                     Map<String, Object> attributes){
//        return ofGoogle(userNameAttributeName, attributes);
//    }
//
//    private static OAuthAttributes ofGoogle(String userNameAttributeName,
//                                            Map<String, Object> attributes){ //엑세스 토큰에서 가져온 사용자 정보 파싱
//        return OAuthAttributes.builder()
//                .nickname((String) attributes.get("name"))
//                .email((String) attributes.get("email"))
//                .picture((String) attributes.get("picture"))
//                .provider((String) attributes.get("provider"))
//                .attributes(attributes)
//                .nameAttributeKey(userNameAttributeName)
//                .build();
//    }
//
//    public Member toEntity(){
//        return Member.builder()
//                .nickname(nickname)
//                .email(email)
//                .picture(picture)
//                .role(Role.GUEST)
//                .build();
//    }

}
