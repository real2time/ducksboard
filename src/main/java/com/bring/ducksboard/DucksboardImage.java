package com.bring.ducksboard;

public enum DucksboardImage {
    ORANGE("https://app.ducksboard.com/static/img/timeline/orange.gif"),
    RED("https://app.ducksboard.com/static/img/timeline/red.gif"),
    GREEN("https://app.ducksboard.com/static/img/timeline/green.gif"),
    CREATED("https://app.ducksboard.com/static/img/timeline/created.png"),
    EDITED("https://app.ducksboard.com/static/img/timeline/edited.png"),
    DELETED("https://app.ducksboard.com/static/img/timeline/deleted.png")
    ;
    private final String url;

    DucksboardImage(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
