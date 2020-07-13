package org.techtown.sample_customlistview;

public class Item {

    String name;
    String extra01="";
    String extra02="";

    public Item(String name){
        this.name =name;
    }

    public Item(String name, String extra01, String extra02){
        this.name =name;
        this.extra01 =extra01;
        this.extra02 =extra02;
    }

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getExtra01(){
        return extra01;
    }
    public void setExtra01(String extra01){
        this.extra01 = extra01;
    }

    public String getExtra02(){
        return extra02;
    }
    public void setExtra02(String extra02){
        this.extra02 = extra02;
    }
}
