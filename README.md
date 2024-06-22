# MusiShop
SpringBoot /
JPA + mybatis/
mysql /
thymeleaf /
SpringSecurity,OAuth2


<img width="1493" alt="스크린샷 2024-02-17 오후 3 38 55" src="https://github.com/Kim-Dayeong/MusiShop/assets/114847045/9fcb2c59-9a37-4f3e-bd5c-ba238008c7f4">

# 서비스 개요

MusiShop 서비스는 아티스트 회원의 앨범 공유와 아티스트 팬 커뮤니티를 위해 개발된 1인 개발 웹 커뮤니티 사이트입니다. 

누구나 아티스트가 되어 자신의 앨범을 공유할 수 있고, 누구나 팬이 되어 원하는 아티스트의 커뮤니티에서 활동할 수 있습니다.

# 서비스 구성도 

# 상세 기능 
### 메인페이지 
-인기앨범, 최신앨범 메인에 띄우기
### 회원기능
-스프링 시큐리티 로그인과 google oauth 로그인

-회원 수정및 탈퇴

-일반 회원과 아티스트 회원 구분 회원가입
### 게시판 기능 
-CRUD와 댓글, 북마크 기능
### 앨범 기능 
-아티스트 회원만 CRUD 가능

-앨범에 음악 추가 기능

-앨범 좋아요 기능

### 플레이리스트 기능
-플레이리스트 생성,추가,조회 기능
### 아티스트 채널과 아티스트 커뮤니티 기능
-아티스트 회원으로 가입시 채널 자동 생성

-채널 하나당 하나의 커뮤니티 생성, 해당 아티스트회원의 팬 커뮤니티 기능 

### 마이페이지 기능
-유저정보 수정, 조회, 탈퇴 
### 어드민 기능 
-admin 계정만 접근 가능

-전체 앨범 및 게시글 조회 및 삭제

-회원 조회 및 삭제 
### 검색기능
-하나의 검색 키워드로 전체 앨범,플레이리스트,게시판 통합 검색기능 
## Preview
![image](https://github.com/Kim-Dayeong/MusiShop/assets/114847045/46e00d54-b8d6-4a93-8d99-61582afe6e27)
![image](https://github.com/Kim-Dayeong/MusiShop/assets/114847045/40ad9760-5c9c-4e89-b35f-1b3242212e1b)
![image](https://github.com/Kim-Dayeong/MusiShop/assets/114847045/e79011fd-e354-4082-9ab2-14eb8f8afe28)
![image](https://github.com/Kim-Dayeong/MusiShop/assets/114847045/ea837e26-f468-4e4a-9455-b70ab4749550)
![image](https://github.com/Kim-Dayeong/MusiShop/assets/114847045/f1fd4fd8-01b2-468a-a7bf-c4100acd7edf)
![image](https://github.com/Kim-Dayeong/MusiShop/assets/114847045/b6176032-c088-4b6b-a80c-9d21b01752f7)

[상세기능 더보기](https://yy000889.tistory.com/827)


배포 : Aws ec2 , Docker 
배포 링크 | http://musishop.duckdns.org:8083/ 

