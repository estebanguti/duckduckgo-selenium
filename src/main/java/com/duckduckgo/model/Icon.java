package com.duckduckgo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Icon {

    @JsonProperty("Height")
    private String height;
    @JsonProperty("URL")
    private String url;
    @JsonProperty("Width")
    private String width;

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }
}
