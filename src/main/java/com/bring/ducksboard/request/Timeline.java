package com.bring.ducksboard.request;

import com.bring.ducksboard.DucksboardImage;
import com.bring.ducksboard.DucksboardObject;
import com.google.gson.JsonObject;

public class Timeline implements DucksboardObject {
    
    private String title;
    private String image;
    private String content;
    private String link;

    public Timeline(String title, String image, String content, String link) {
        this.title = title;
        this.image = image;
        this.content = content;
        this.link = link;
    }

    public Timeline(String title, DucksboardImage image, String content, String link) {
        this(title, image.getUrl(), content, link);
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getContent() {
        return content;
    }

    public String getLink() {
        return link;
    }

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        json.addProperty("title", title);
        json.addProperty("image", image);
        json.addProperty("content", content);
        json.addProperty("link", link);

        JsonObject value = new JsonObject();
        value.add("value", json);

        return value;
    }
}
