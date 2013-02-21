package com.bring.ducksboard.request;

import com.bring.ducksboard.DucksboardObject;
import com.google.gson.JsonObject;
import org.joda.time.DateTime;

import java.math.BigDecimal;

public class ValueWithTimestamp implements DucksboardObject {
    private BigDecimal value;
    private DateTime time;

    public ValueWithTimestamp(BigDecimal value, DateTime time) {
        this.value = value;
        this.time = time;
    }

    public ValueWithTimestamp(int value, DateTime time) {
        this(new BigDecimal(value), time);
    }

    public BigDecimal getValue() {
        return value;
    }

    public DateTime getTime() {
        return time;
    }

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        json.addProperty("value", value);
        json.addProperty("timestamp", time.getMillis() / 1000);
        return json;
    }

}
