
package com.example.pc43.mydesigndemo.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Recycler {

    @SerializedName("inner_child")
    @Expose
    private List<InnerChild> innerChild = null;

    public List<InnerChild> getInnerChild() {
        return innerChild;
    }

    public void setInnerChild(List<InnerChild> innerChild) {
        this.innerChild = innerChild;
    }

}
