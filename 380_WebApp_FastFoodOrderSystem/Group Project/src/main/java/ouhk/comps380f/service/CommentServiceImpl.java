package ouhk.comps380f.service;

import java.io.IOException;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ouhk.comps380f.dao.CommentRepository;
import ouhk.comps380f.model.Comment;

@Service
public class CommentServiceImpl implements CommentService{
    
    @Resource
    private CommentRepository CommentRepo;
    
    @Override
    @Transactional
    public List<Comment> getComments() {
        return CommentRepo.findAll();
    }
    
    @Override
    @Transactional
    public Comment getComment(long id) {
        return CommentRepo.findById(id).orElse(null);
    }
    
     public void createComment(String username, String comment, long Id)throws IOException{
         Comment com = new Comment();
         com.setUsername(username);
         com.setComment(comment);
         com.setId(Id);
         Comment savedComment = CommentRepo.save(com);
        }
}
