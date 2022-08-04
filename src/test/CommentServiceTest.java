package test;

import entity.Comment;
import org.junit.jupiter.api.Test;
import service.CommentService;
import service.CommentServiceJDBC;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommentServiceTest {
    private CommentService commentService = new CommentServiceJDBC();

    @Test
    public void testReset() {
        commentService.addComment(new Comment("minesweeper", "Peter", "commentPeter", new Date()));
        commentService.reset();
        assertEquals(0, commentService.getComments("").size());
    }

    ;


    @Test
    public void testAddScore() {
        commentService.reset();
        var date = new Date();
        commentService.addComment(new Comment("minesweeper", "Peter", "commentPeter", date));


        var comments = commentService.getComments("minesweeper");


        assertEquals(1, comments.size());
        assertEquals("minesweeper", comments.get(0).getGame());
        assertEquals("Peter", comments.get(0).getUsername());
        assertEquals("commentPeter", comments.get(0).getComment());
        assertEquals(date, comments.get(0).getCommentedOn());



    }


    @Test
    public void testGetBestScores() {
        commentService.reset();
        var date = new Date();
        commentService.addComment(new Comment("minesweeper", "Peto", "commentPeto", date));
        commentService.addComment(new Comment("minesweeper", "Katka", "commentKatka", date));
        commentService.addComment(new Comment("tiles", "Zuzka", "commentZuzka", date));
        commentService.addComment(new Comment("minesweeper", "Jergus", "commentJergus", date));

        var comments = commentService.getComments("minesweeper");

        assertEquals(3, comments.size());

        assertEquals("minesweeper", comments.get(0).getGame());
        assertEquals("Katka", comments.get(0).getUsername());
        assertEquals("commentKatka", comments.get(0).getComment());
        assertEquals(date, comments.get(0).getCommentedOn());

        assertEquals("minesweeper", comments.get(1).getGame());
        assertEquals("Peto", comments.get(1).getUsername());
        assertEquals("commentPeto", comments.get(1).getComment());
        assertEquals(date, comments.get(1).getCommentedOn());

        assertEquals("minesweeper", comments.get(2).getGame());
        assertEquals("Jergus", comments.get(2).getUsername());
        assertEquals("commentJergus", comments.get(2).getComment());
        assertEquals(date, comments.get(2).getCommentedOn());
    }

}