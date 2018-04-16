package com.albenyuan.jvm.classloader;

import java.io.Serializable;

/**
 * @Author Alben Yuan
 * @Date 2018-04-16 17:22
 */
public class Entity implements Serializable {

    private static final long serialVersionUID = 3460059538064562815L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Entity{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
