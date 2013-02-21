package com.bring.ducksboard.request;

import com.bring.ducksboard.DucksboardObject;
import com.bring.ducksboard.DucksboardRequest;
import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.List;

public class ListOfValues implements DucksboardRequest {

    private List<? extends DucksboardObject> list;

    public ListOfValues(List<? extends DucksboardObject> list) {
        this.list = new ArrayList<DucksboardObject>(list);
    }

    public List<? extends DucksboardObject> getList() {
        return list;
    }

    public JsonArray toJson() {
        JsonArray jsonArray = new JsonArray();

        for (DucksboardObject ducksboardObject : list) {
            jsonArray.add(ducksboardObject.toJson());
        }

        return jsonArray;
    }
}
