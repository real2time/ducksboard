package com.bring.ducksboard.request;

import com.bring.ducksboard.DucksboardObject;
import com.google.gson.JsonObject;

import java.math.BigDecimal;

public class Value implements DucksboardObject {
    
    private BigDecimal value;

    public Value(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }
    
    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        json.addProperty("value", value);
        return json;
    }
}
