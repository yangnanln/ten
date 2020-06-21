package com.tensquare.article.repository;

import com.tensquare.article.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String> {

    //根据文章id查询评论列表
    List<Comment> findByArticleid(String articleId);


    //根据发布时间和点赞数查询查询
     List<Comment> findByPublishdateAndThumbup(Date date, Integer thumbup);

    //根据用户id查询，并且根据发布时间倒序排序
     List<Comment> findByUseridOrderbOrderByPublishdateDesc(String userid);
}
