package com.bring.ducksboard.request;

import com.bring.ducksboard.DucksboardObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

public class LeaderBoard implements DucksboardObject {

    private List<BoardMember> boardMembers;

    public LeaderBoard(List<BoardMember> boardMembers) {
        this.boardMembers = boardMembers;
    }

    public int count() {
        return boardMembers.size();
    }

    public JsonObject toJson() {
        JsonArray boardJson = new JsonArray();

        for (BoardMember boardMember : boardMembers) {
            boardJson.add(boardMember.toJson());
        }

        JsonObject json = new JsonObject();

        json.add("board", boardJson);

        JsonObject jsonOuter = new JsonObject();
        jsonOuter.add("value", json);
        return jsonOuter;
    }
}
