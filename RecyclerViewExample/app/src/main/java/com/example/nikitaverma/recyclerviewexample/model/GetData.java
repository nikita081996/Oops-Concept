package com.example.nikitaverma.recyclerviewexample.model;

import com.google.gson.annotations.SerializedName;

/**
 * SubClass of Book class using GET method
 */
public class GetData {

    @SerializedName("id")
    private String age;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

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

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String first_name)
    {
        this.firstName = first_name;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String last_name)
    {
        this.lastName = last_name;
    }

    public String getAvatar ()
    {
        return avatar;
    }

    public void setAvatar (String avatar)
    {
        this.avatar = avatar;
    }

}
