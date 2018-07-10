package com.example.nikitaverma.recyclerviewexample.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Model for mapping data for GET method
 */
public class Book {

    @SerializedName("total")
    private String total;

    @SerializedName("per_page")
    private String perPage;

    @SerializedName("page")
    private String page;

    @SerializedName("data")
    private List<GetData> data;

    @SerializedName("total_pages")
    private String totalPages;

    public String getTotal ()
    {
        return total;
    }

    public void setTotal (String total)
    {
        this.total = total;
    }

    public String getPerPage ()
    {
        return perPage;
    }

    public void setPerPage(String perPage)
    {
        this.perPage = perPage;
    }

    public String getPage ()
    {
        return page;
    }

    public void setPage (String page)
    {
        this.page = page;
    }

    public List<GetData> getData ()
    {
        return data;
    }

    public void setData (List<GetData> data)
    {
        this.data = data;
    }


    public String getTotalPages()
    {
        return totalPages;
    }

    public void setTotalPages(String totalPages)
    {
        this.totalPages = totalPages;
    }

}
