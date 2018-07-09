package com.example.nikitaverma.recyclerviewexample.Model;

/**
 * Request data for POST
 */
public class PostData {

    private String name;

    private String job;

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getJob ()
    {
        return job;
    }

    public void setJob (String job)
    {
        this.job = job;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [name = "+name+", job = "+job+"]";
    }

}
