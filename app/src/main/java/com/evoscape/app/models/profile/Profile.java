package com.evoscape.app.models.profile;

import java.io.Serializable;

public class Profile implements Serializable {
    private String id, name, email, phone, image;

    public Profile(String id, String name, String email, String phone, String image) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getImage() {
        return image;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
