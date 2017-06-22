package com.hjj.ben.model;

import javax.persistence.*;

/**
 * Created by ben on 6/22/17.
 */
@Entity
@Table(name = "novel_detail")
public class NovelDetail {

    private Integer id;

    @Column(name = "res_id")
    private String resId;

    private String name;
    private String author;

    @Column(name = "author_href")
    private String authorHref;
    private String picture;

    @Column(name = "update_time")
    private String updateTime;
    private String status;
    private String type;

    @Column(name = "type_href")
    private String typeHref;
    private String source;
    private String description;

    @Column(name = "latest_chapters")
    private String latestChapters;

    @Column(name = "chapters_categore_href")
    private String chaptersCategoreHref;

    @GeneratedValue
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorHref() {
        return authorHref;
    }

    public void setAuthorHref(String authorHref) {
        this.authorHref = authorHref;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeHref() {
        return typeHref;
    }

    public void setTypeHref(String typeHref) {
        this.typeHref = typeHref;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLatestChapters() {
        return latestChapters;
    }

    public void setLatestChapters(String latestChapters) {
        this.latestChapters = latestChapters;
    }

    public String getChaptersCategoreHref() {
        return chaptersCategoreHref;
    }

    public void setChaptersCategoreHref(String chaptersCategoreHref) {
        this.chaptersCategoreHref = chaptersCategoreHref;
    }

    @Override
    public String toString() {
        return "NovelDetail{" +
                "id=" + id +
                ", resId='" + resId + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", authorHref='" + authorHref + '\'' +
                ", picture='" + picture + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", typeHref='" + typeHref + '\'' +
                ", source='" + source + '\'' +
                ", description='" + description + '\'' +
                ", latestChapters='" + latestChapters + '\'' +
                ", chaptersCategoreHref='" + chaptersCategoreHref + '\'' +
                '}';
    }
}
