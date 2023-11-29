package com.musi.shop.web;

import com.musi.shop.web.Service.AlbumService;
import com.musi.shop.web.controller.AlbumController;
import com.musi.shop.web.entity.Album;
import com.musi.shop.web.entity.Song;
import com.musi.shop.web.repository.AlbumRepository;
import com.musi.shop.web.repository.SongRepository;
import com.musi.shop.web.web.dto.AlbumDto;
import com.musi.shop.web.web.dto.SongDto;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlbumTest {

    @Mock
    private AlbumRepository albumRepository;

    @Mock
    private SongRepository songRepository;

    @Mock
    private Model model;

    @InjectMocks
    private AlbumService albumService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new AlbumController(albumService)).build();
    }

    @Test
    public void testAlbumView() throws Exception {

        Album fakeAlbum = new Album();
        fakeAlbum.setId(1L);
        fakeAlbum.setTitle("Fake Album");
        // Given
        Long albumId = 1L;
        Album album = new Album(); // create a sample album object
        album.setId(albumId);
        // Add other necessary properties to the album...

        List<Song> songs = Arrays.asList(new Song(), new Song()); // create sample songs
        when(albumRepository.findById(albumId)).thenReturn(Optional.of(album));
        when(songRepository.findByAlbumId(albumId)).thenReturn(songs);

        // When
        mockMvc.perform(get("/album/view/{no}", albumId))
                .andExpect(status().isOk())
                .andExpect(view().name("albumview.html"));

        // Then
        verify(model).addAttribute("albumDto", new AlbumDto(album));
    }

    @Test
    public void testGetAlbumById() {
        // 가짜 Album 데이터 생성
        Album fakeAlbum = new Album();
        fakeAlbum.setId(1L);
        fakeAlbum.setTitle("Fake Album");

        // Mocking: albumRepository.findById(albumId) 호출 시 가짜 데이터(fakeAlbum) 반환
        when(albumRepository.findById(1L)).thenReturn(Optional.of(fakeAlbum));

        // 특정 albumId에 대한 조회
        AlbumDto result = albumService.getAlbumWithSongs(1L);

        // 결과 확인
        assertEquals(1L, result.getId().longValue());
        assertEquals("Fake Album", result.getTitle());

        // albumRepository.findById(albumId) 메서드가 1번 호출되었는지 검증
        verify(albumRepository, times(1)).findById(1L);
    }
}
