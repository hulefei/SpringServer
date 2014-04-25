package com.springserver.po;

/**
 * Created by hanson on 14-4-25.
 */
public class HelloEntity {
    private int pkid;
    private String name;
    private int age;

    public int getPkid() {
        return pkid;
    }

    public void setPkid(int pkid) {
        this.pkid = pkid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("pkid:").append(pkid).append(";");
        buf.append("name:").append(name).append(";");
        buf.append("age:").append(age).append(";");

        return buf.toString();
    }
}
