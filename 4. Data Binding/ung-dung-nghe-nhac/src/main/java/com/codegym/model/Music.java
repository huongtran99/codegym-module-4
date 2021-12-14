package com.codegym.model;

public class Music {
    private int id;
    private String name;
    private String singer;
    private Type type;
    private String source;

    public Music() {

    }

    public Music(int id, String name, String singer, Type type, String source) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.type = type;
        this.source = source;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
