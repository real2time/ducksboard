package com.bring.ducksboard.request;

import com.bring.ducksboard.DucksboardObject;
import com.google.gson.JsonObject;

import java.math.BigDecimal;

public class Delta implements DucksboardObject {
    
    private BigDecimal delta;

    public Delta(BigDecimal delta) {
        this.delta = delta;
    }

    public BigDecimal getDelta() {
        return delta;
    }
    
    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        json.addProperty("delta", delta);
        return json;
    }
}
