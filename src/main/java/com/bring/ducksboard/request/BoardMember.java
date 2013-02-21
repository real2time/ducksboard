package com.bring.ducksboard.request;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.math.BigDecimal;

public class BoardMember {

    public enum Trend {
        UP("up"),
        DOWN("down"),
        EQUAL("equal"),
        NULL("null");
        private String jsonString;

        Trend(String jsonString) {
            this.jsonString = jsonString;
        }

        public String getJsonString() {
            return jsonString;
        }
    }

    private String name;
    private Trend trend;
    private BigDecimal[] values;

    public BoardMember(String name, BigDecimal... value) {
        this.name = name;
        this.values = value;
        this.trend = Trend.NULL;
    }
    
    public BoardMember(String name, Trend trend, BigDecimal... values) {
        this.name = name;
        this.trend = trend;
        this.values = values;
    }

    public String getName() {
        return name;
    }

    public Trend getTrend() {
        return trend;
    }

    public BigDecimal[] getValues() {
        return values;
    }

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        json.addProperty("name", name);
        JsonArray jsonArray = new JsonArray();

        for (BigDecimal value : values) {
            jsonArray.add(new JsonPrimitive(value));
        }
        
        if (trend != Trend.NULL) {
            json.addProperty("trend", trend.getJsonString());
        }

        json.add("values", jsonArray);
        return json;
    }
}

