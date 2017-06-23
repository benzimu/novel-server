package com.hjj.ben.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;

/**
 * Created by ben on 6/22/17.
 */
@Entity
@Table(name = "novel_chapters")
public class NovelChapters {

    @GeneratedValue
    @Id
    private Integer id;

    @Column(name = "res_id")
    private Integer resId;

    @Column(name = "novel_detail_id")
    private Integer novelDetailId;
    private String source;
    private String counts;
    private String name;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public Integer getNovelDetailId() {
        return novelDetailId;
    }

    public void setNovelDetailId(Integer novelDetailId) {
        this.novelDetailId = novelDetailId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCounts() {
        return counts;
    }

    public void setCounts(String counts) {
        this.counts = counts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NovelChapters() {
    }

    public NovelChapters(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "NovelChapters{" +
                "id=" + id +
                ", resId=" + resId +
                ", novelDetailId=" + novelDetailId +
                ", source='" + source + '\'' +
                ", counts='" + counts + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

}
