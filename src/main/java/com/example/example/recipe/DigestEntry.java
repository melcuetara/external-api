package com.example.example.recipe;

public class DigestEntry {
    private String label;
    private String tag;
    private String schemaOrgTag;
    private double total;
    private Boolean hasRDI;
    private double daily;
    private String unit;
    private Digest sub;
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getSchemaOrgTag() {
        return schemaOrgTag;
    }
    public void setSchemaOrgTag(String schemaOrgTag) {
        this.schemaOrgTag = schemaOrgTag;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public Boolean getHasRDI() {
        return hasRDI;
    }
    public void setHasRDI(Boolean hasRDI) {
        this.hasRDI = hasRDI;
    }
    public double getDaily() {
        return daily;
    }
    public void setDaily(double daily) {
        this.daily = daily;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public Digest getSub() {
        return sub;
    }
    public void setSub(Digest sub) {
        this.sub = sub;
    }

    
}
