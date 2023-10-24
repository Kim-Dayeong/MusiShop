//package com.musi.shop.web.entity;
//
//
//import com.musi.shop.web.web.domain.BaseTimeEntity;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Getter
//@NoArgsConstructor
//@Entity
//public class OauthMember extends BaseTimeEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false)
//    private String name;
//
//    @Column(nullable = false)
//    private String email;
//
//    @Column
//    private String picture;
//
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private Role role;
//
//    @Column
//    private String providerId;
//
//    @Builder
//    public OauthMember(String name, String email, String picture, Role role, String providerId){
//        this.name = name;
//        this.email = email;
//        this.picture = picture;
//        this.role = role;
//        this.providerId = providerId;
//    }
//
//    public OauthMember update(String name, String picture){
//        this.name = name;
//        this.picture = picture;
//
//        return this;
//    }
//
//    public String getRoleKey(){
//        return this.role.getKey();
//    }
//}
