package com.musi.shop.web.entity;


import com.musi.shop.web.entity.channel.Channel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;



@Entity(name = "Member")
@NoArgsConstructor
@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long id;

    private String nickname;
    private String username; //email
    private Role role;
    private String password;
    private String email;
    private String picture;

    private String provider;
    private String providerId;

    @CreationTimestamp
    private Timestamp createDate;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "heartId")
//    private Heart heart;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "albumId")
//    private Album album;



    //private LocalDateTime last_login_time;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Channel channel;

    @Builder
    public Member(String username, String password, String nickname, String email, Role role, String providerId, String provider, String picture){
        this.username = username;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.role = role;
        this.provider = provider;
        this.providerId = providerId;
        this.picture = picture;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }

        public Member update(String nickname, String picture, String password){
        this.nickname = nickname;
        this.picture = picture;
        this.password = password;

        return this;
    }



}
