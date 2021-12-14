package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class MusicForm {
    private String name;
    private String singer;
    private Type type;
    private MultipartFile source;

    public MusicForm() {

    }

    public MusicForm(String name, String singer, Type type, MultipartFile source) {
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

    public MultipartFile getSource() {
        return source;
    }

    public void setSource(MultipartFile source) {
        this.source = source;
    }
}

