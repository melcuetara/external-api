package com.example.example.recipe;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InlineModel1 {

    @JsonProperty("THUMBNAIL") 
    public ImageInfo tHUMBNAIL;
    @JsonProperty("SMALL") 
    public ImageInfo sMALL;
    @JsonProperty("REGULAR") 
    public ImageInfo rEGULAR;
    @JsonProperty("LARGE") 
    public ImageInfo lARGE;
    public ImageInfo gettHUMBNAIL() {
        return tHUMBNAIL;
    }
    public void settHUMBNAIL(ImageInfo tHUMBNAIL) {
        this.tHUMBNAIL = tHUMBNAIL;
    }
    public ImageInfo getsMALL() {
        return sMALL;
    }
    public void setsMALL(ImageInfo sMALL) {
        this.sMALL = sMALL;
    }
    public ImageInfo getrEGULAR() {
        return rEGULAR;
    }
    public void setrEGULAR(ImageInfo rEGULAR) {
        this.rEGULAR = rEGULAR;
    }
    public ImageInfo getlARGE() {
        return lARGE;
    }
    public void setlARGE(ImageInfo lARGE) {
        this.lARGE = lARGE;
    }

    
    
}
