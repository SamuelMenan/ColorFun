package com.backend.colorFun.model;

public class Drawing {
    private String id;
    private String level;
    private String svgContent;

    public Drawing() {
    }

    public Drawing(String id, String level, String svgContent) {
        this.id = id;
        this.level = level;
        this.svgContent = svgContent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSvgContent() {
        return svgContent;
    }

    public void setSvgContent(String svgContent) {
        this.svgContent = svgContent;
    }
}
