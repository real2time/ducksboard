package com.bring.ducksboard.request;

import com.bring.ducksboard.DucksboardObject;
import com.google.gson.JsonObject;

public class Image implements DucksboardObject {

    private String source;
    private String caption;

    public Image(String source, String caption) {
        this.source = source;
        this.caption = caption;
    }

    public String getSource() {
        return source;
    }

    public String getCaption() {
        return caption;
    }

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        json.addProperty("source", source);
        json.addProperty("caption", caption);
        return json;
    }
}
