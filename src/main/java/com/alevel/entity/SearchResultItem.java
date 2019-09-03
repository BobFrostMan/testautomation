package com.alevel.entity;

public class SearchResultItem {

    private String linkText;
    private String text;
    
    public SearchResultItem(){
        
    }

    public boolean containsInfo(String info){
        return getLinkText().toLowerCase().contains(info.toLowerCase()) ||
                getText().toLowerCase().contains(info.toLowerCase());
    }

    public String getLinkText() {
        return linkText;
    }

    public void setLinkText(String linkText) {
        this.linkText = linkText;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "SearchResultItem{" +
                "linkText='" + linkText + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
