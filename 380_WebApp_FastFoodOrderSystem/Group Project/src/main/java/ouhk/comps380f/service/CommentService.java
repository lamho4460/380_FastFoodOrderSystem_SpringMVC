package ouhk.comps380f.service;

import java.io.IOException;
import java.util.List;
import ouhk.comps380f.model.Comment;

public interface CommentService {
    
    public void createComment(String username, String comment, long Id)throws IOException;
        
  public List<Comment> getComments();

    public Comment getComment(long id);
    
}
