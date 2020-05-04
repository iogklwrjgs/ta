package org.example.ta.bo;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.example.ta.utils.JsonConverter;

import java.net.URL;

public class User {
    private String id;
    private String email;
    private String first_name;
    private String last_name;
    private URL avatar;

    public User(String id, String email, String first_name, String last_name, URL avatar) {
        this.id = id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
    }

    public String getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public URL getAvatar() {
        return this.avatar;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirst_name(String firstName) {
        this.first_name = firstName;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setAvatar(URL avatar) {
        this.avatar = avatar;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.id)
                .append(this.email)
                .append(this.first_name)
                .append(this.last_name)
                .append(this.avatar)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof User)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        final User otherUser = (User) obj;
        return new EqualsBuilder()
                .append(this.id, otherUser.id)
                .append(this.email, otherUser.email)
                .append(this.first_name, otherUser.first_name)
                .append(this.last_name, otherUser.last_name)
                .append(this.avatar, otherUser.avatar)
                .isEquals();
    }

    @Override
    public String toString() {
        return JsonConverter.convertToJson(this);
    }
}
