package com.example.nikitaverma.recyclerviewexample.Model;

import com.google.gson.annotations.SerializedName;

/**
 * SubClass of Book class using GET method
 */
public class Data {

    @SerializedName("id")
    private String age;

    @SerializedName("first_name")
    private String firstname;

    @SerializedName("last_name")
    private String lastname;

    @SerializedName("avatar")
    private String avatar;

    public String getAge ()
    {
        return age;
    }

    public void setAge (String id)
    {
        this.age = id;
    }

    public String getFirstname ()
    {
        return firstname;
    }

    public void setFirstname (String first_name)
    {
        this.firstname = first_name;
    }

    public String getLastname ()
    {
        return lastname;
    }

    public void setLastname (String last_name)
    {
        this.lastname = last_name;
    }

    public String getAvatar ()
    {
        return avatar;
    }

    public void setAvatar (String avatar)
    {
        this.avatar = avatar;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+age+", first_name = "+firstname+", last_name = "+lastname+", avatar = "+avatar+"]";
    }
}
