package com.musi.shop.web.service.board;

import com.musi.shop.web.entity.Member;
import com.musi.shop.web.entity.board.Board;
import com.musi.shop.web.entity.board.Bookmark;
import com.musi.shop.web.repository.board.BoardReporitory;
import com.musi.shop.web.repository.board.BookmarkRepository;
import com.musi.shop.web.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {

    @Autowired
    private BoardReporitory boardReporitory;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BookmarkRepository bookmarkRepository;

    public Board findBoard(Long boardId){
        Optional<Board> boardOptional = boardReporitory.findById(boardId);
        Board board = boardOptional.orElseThrow(() -> new IllegalArgumentException());
        return board;
    }

    public Member findMember(String username){
        Optional<Member> memberOptional = memberRepository.findByUsername(username);
        Member member = memberOptional.orElseThrow(() -> new IllegalArgumentException());
        return member;
    }

        @Transactional
        public boolean bookmarking(Board board, Member member) {

            Bookmark bookmark = bookmarkRepository.findByMemberAndBoard(member, board);
            // 북마크가 이미 존재할 경우, 조회된 북마크를 db에서 삭제하여 북마크를 해제한다.
            if (bookmark != null) {
                bookmarkRepository.delete(bookmark);
                return false;
            }
            // 북마크가 존재하지 않을 경우, 북마크를 db 추가하여 북마크를 설정한다.
            bookmark = new Bookmark();
            bookmark.setMember(member);
            bookmark.setBoard(board);
            bookmarkRepository.save(bookmark);
            return true;
        }
}
