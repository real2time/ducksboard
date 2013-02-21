package com.bring.ducksboard;

public class DucksboardId {
    private String id;

    protected DucksboardId(String id, String suffix) {
        this.id = id + suffix;
    }

    public String getId() {
        return id;
    }
}
