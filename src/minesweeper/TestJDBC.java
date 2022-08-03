package minesweeper;

import service.ScoreService;
import service.ScoreServiceJDBC;

public class TestJDBC {

    public static void main(String[] args) throws Exception {
        ScoreService service = new ScoreServiceJDBC();
        service.reset();
    }
    }


