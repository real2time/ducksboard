package com.bring.ducksboard;

import com.bring.ducksboard.request.BoardMember;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class BoardMemberTest {
    @Test
    public void should_serialize_ToJson() throws Exception {
        BoardMember boardMember = new BoardMember("dom", new BigDecimal(100));
        assertEquals("{\"name\":\"dom\",\"values\":[100]}", boardMember.toJson().toString());
    }
}
