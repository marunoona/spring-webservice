package com.marunoona.webservice.domain.posts;

import com.marunoona.webservice.dto.posts.PostsMainResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.stream.Stream;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p " +
            "FROM Posts p " +
            "ORDER BY p.id DESC")
    Stream<Posts> findAllDesc();

    @Modifying
    @Query("UPDATE Posts p "
            + "SET p.title = :title, "
            + "p.content = :content "
            + "WHERE p.id= :id")
    void modify(@Param("title") String title, @Param("content") String content
            , @Param("id") Long id);
}
