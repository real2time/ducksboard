package com.bring.ducksboard;

import com.bring.ducksboard.request.BoardMember;
import com.bring.ducksboard.request.LeaderBoard;
import org.junit.Test;

import java.math.BigDecimal;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class LeaderBoardTest {
    @Test
    public void should_ToJson() throws Exception {
        BoardMember dom = new BoardMember("dom", new BigDecimal(100));
        BoardMember christian = new BoardMember("Christian", new BigDecimal(120));
        LeaderBoard leaderBoard = new LeaderBoard(asList(dom, christian));
        assertEquals("{\"value\":{\"board\":[{\"name\":\"dom\",\"values\":[100]},{\"name\":\"Christian\",\"values\":[120]}]}}", leaderBoard.toJson().toString());
    }
}
