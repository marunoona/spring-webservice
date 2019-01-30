package com.marunoona.webservice.domain.posts;

import com.marunoona.webservice.dto.posts.PostsResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.stream.Stream;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p " +
            "FROM Posts p " +
            "ORDER BY p.id DESC")
    Stream<Posts> findAllDesc();

    @Query("SELECT p " +
            "FROM Posts p " +
            "WHERE p.id = :id")
    Optional<Posts> findById(@Param("id") long id);

    @Query("SELECT p " +
            "FROM Posts p " +
            "WHERE p.id = :id")
    PostsResponseDto findOneById(@Param("id") long id);
}
