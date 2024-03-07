package com.musi.shop.web.adminpage;

import com.musi.shop.web.entity.album.Album;
import com.musi.shop.web.entity.board.Board;
import com.musi.shop.web.repository.album.AlbumRepository;
import com.musi.shop.web.repository.board.BoardReporitory;
import com.musi.shop.web.repository.channel.ChannelRepository;
import com.musi.shop.web.repository.comment.CommentRepository;
import com.musi.shop.web.repository.community.CommunityRepository;
import com.musi.shop.web.repository.member.MemberRepository;
import com.musi.shop.web.service.admin.AdminpageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminpageController {

    @Autowired
    AdminpageService adminpageService;

    // 앨범, 커뮤니티, 댓글, 회원, 채널, 게시판 삭제 및 조회 기능


    //앨범
    @GetMapping("/album/list")
    public String albumList(Model model, @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Album> list = adminpageService.albumList(pageable);

        // list가 null인 경우 처리
        if (list == null) {
            // 에러 처리 등을 수행할 수 있음
            return "error"; // 예시로 error 페이지로 리다이렉트
        }

        int nowPage = list.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage - 3, 1);
        int endPage = Math.min(nowPage + 3, list.getTotalPages());
        int startTotal = 0;
        int endTotal = list.getTotalPages() - 1;

        model.addAttribute("list", list);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("startTotal", startTotal);
        model.addAttribute("endTotal", endTotal);

        return "admin/admin-albumlist";
    }

    @PostMapping("/album/delete/{id}")
    public String albumDelte(@PathVariable Long id){

        adminpageService.albumdelte(id);
        return "admin/admin-main";
    }


    // 게시판

    @GetMapping("/board/list")
    public String boardList(Model model, @PageableDefault(page = 0, size = 10, sort = "id",direction = Sort.Direction.DESC) Pageable pageable){


        Page<Board> list = adminpageService.boardList(pageable);

        //페이지 블럭 처리
        int nowPage = list.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage -3, 1);
        int endPage = Math.min(nowPage + 3, list.getTotalPages());
        int starttotal = 0;
        int endtotal = list.getTotalPages()-1;

        model.addAttribute("list", list);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("starttotal", starttotal);
        model.addAttribute("endtotal", endtotal);

        return "admin/admin-boardlist";
    }


    @PostMapping("/board/delete/{id}")
    public String boardDelte(@PathVariable Long id){

        adminpageService.boardDelte(id);
        return "admin/admin-main";
    }

    // 회원





}
