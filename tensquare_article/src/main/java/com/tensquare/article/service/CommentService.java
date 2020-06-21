package com.tensquare.article.service;

import com.tensquare.article.pojo.Comment;
import com.tensquare.article.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;
import java.util.Date;
import java.util.List;
@Service
public class CommentService {
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CommentRepository commentDao;
    public void thumbup(String id) {
        //查询评论
        Comment comment = commentDao.findById(id).get();
        //修改点赞数
        comment.setThumbup(comment.getThumbup() + 1);

        commentDao.save(comment);
    }

    public List<Comment> findByArticleId(String articleId) {
        return commentDao.findByArticleid(articleId);
    }
    public Comment findById(String id) {
        return commentDao.findById(id).get();
    }
    public List<Comment> findAll() {
        return commentDao.findAll();
    }
    public void save(Comment comment) {
        String id = idWorker.nextId() + "";
        comment.set_id(id);
        //初始化数据
        comment.setPublishdate(new Date());
        comment.setThumbup(0);
        commentDao.save(comment);
    }
    public void update(Comment comment) {
        commentDao.save(comment);
    }
    public void deleteById(String id) {
        commentDao.deleteById(id);
    }
}