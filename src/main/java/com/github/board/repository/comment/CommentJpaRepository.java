package com.github.board.repository.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentJpaRepository extends JpaRepository<Comments, Integer> {

    /**
     * 게시글로 댓글리스트 조회 - user테이블과 조인하여 user 정보를 가져온다.
     * @Param("postIdx") Integer postIdx
     */
    @Query("SELECT c FROM Comments c JOIN FETCH c.user u WHERE c.postsIdx = :postIdx ORDER BY c.createdAt ASC")
    List<Comments> findAllByPostsIdxOrderByCreatedAtAsc(@Param("postIdx") Integer postIdx);

}
