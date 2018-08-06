package com.albenyuan.mybatis.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Menu {
    private Long id;

    private String name;

    private Boolean isDirectory;

    private Long fatherId;

    private String url;

    private String icon;

    private Date createTime;

    private Menu father;

    private List<Menu> child = new ArrayList<>();

    public Menu getFather() {
        return father;
    }

    public void setFather(Menu father) {
        this.father = father;
    }

    public List<Menu> getChild() {
        return child;
    }

    public void setChild(List<Menu> child) {
        this.child = child;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Boolean getIsDirectory() {
        return isDirectory;
    }

    public void setIsDirectory(Boolean isDirectory) {
        this.isDirectory = isDirectory;
    }

    public Long getFatherId() {
        return fatherId;
    }

    public void setFatherId(Long fatherId) {
        this.fatherId = fatherId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Menu{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", isDirectory=").append(isDirectory);
        sb.append(", fatherId=").append(fatherId);
        sb.append(", url='").append(url).append('\'');
        sb.append(", icon='").append(icon).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", father=").append(father);
        sb.append(", child=").append(child);
        sb.append('}');
        return sb.toString();
    }
}