package com.musi.shop.web.repository.comucomment;

import com.musi.shop.web.entity.Comucomment.ComuComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ComucommentRepositroy extends JpaRepository<ComuComment,Long >
{
    List<ComuComment> findByCommunityId(Long comuId); // comuid로 comment 불러오기


}
