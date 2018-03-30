
package com.example.pc43.mydesigndemo.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserResponse {

    @SerializedName("result")
    @Expose
    private String result;
    @SerializedName("recycler")
    @Expose
    private List<Recycler> recycler = null;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<Recycler> getRecycler() {
        return recycler;
    }

    public void setRecycler(List<Recycler> recycler) {
        this.recycler = recycler;
    }

}
