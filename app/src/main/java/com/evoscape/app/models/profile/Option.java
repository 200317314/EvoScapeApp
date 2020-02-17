package com.evoscape.app.models.profile;

public class Option {
    private String id, name, image;
    private Class startActivityClass;

    public Option(String id, String name, String image, Class startActivityClass) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.startActivityClass = startActivityClass;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public Class getStartActivityClass() {
        return startActivityClass;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setStartActivityClass(Class startActivityClass) {
        this.startActivityClass = startActivityClass;
    }
}
