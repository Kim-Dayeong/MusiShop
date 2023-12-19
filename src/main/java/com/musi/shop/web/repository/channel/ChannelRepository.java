package com.musi.shop.web.repository.channel;

import com.musi.shop.web.entity.board.Board;
import com.musi.shop.web.entity.channel.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {
}
