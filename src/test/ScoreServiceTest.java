package test;

import entity.Score;
import org.junit.jupiter.api.Test;
import service.ScoreService;
import service.ScoreServiceJDBC;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ScoreServiceTest {
    private ScoreService scoreService= new ScoreServiceJDBC();
    @Test
    public void testReset(){
        scoreService.addScore(new Score("minesweeper","Janko",5,new Date()));
        scoreService.reset();
        assertEquals(0,scoreService.getBestScores("minesweeper").size());
    }

    @Test
    public void testAddScore() {
        scoreService.reset();
        var date=new Date();
        scoreService.addScore(new Score("minesweeper","Janko",123,date));

        var scores = scoreService.getBestScores("minesweeper");

        assertEquals(1,scores.size());
        assertEquals("minesweeper",scores.get(0).getGame());
        assertEquals("Janko",scores.get(0).getUsername());
        assertEquals(123,scores.get(0).getPoints());
        assertEquals(date,scores.get(0).getPlayedOn());




    }


}
