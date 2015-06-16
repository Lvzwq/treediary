package net.bingyan.treediary.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by ilovey on 5/15/15.
 */
@Entity
@Table(name = "status", schema = "", catalog = "treediary")
public class StatusEntity {
    private int id;
    private String content;
    private Timestamp pubTime;
    private short picNum;
    private String picIds;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "pub_time")
    public Timestamp getPubTime() {
        return pubTime;
    }

    public void setPubTime(Timestamp pubTime) {
        this.pubTime = pubTime;
    }

    @Basic
    @Column(name = "pic_num")
    public short getPicNum() {
        return picNum;
    }

    public void setPicNum(short picNum) {
        this.picNum = picNum;
    }

    @Basic
    @Column(name = "pic_ids")
    public String getPicIds() {
        return picIds;
    }

    public void setPicIds(String picIds) {
        this.picIds = picIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatusEntity that = (StatusEntity) o;

        if (id != that.id) return false;
        if (picNum != that.picNum) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (picIds != null ? !picIds.equals(that.picIds) : that.picIds != null) return false;
        if (pubTime != null ? !pubTime.equals(that.pubTime) : that.pubTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (pubTime != null ? pubTime.hashCode() : 0);
        result = 31 * result + (int) picNum;
        result = 31 * result + (picIds != null ? picIds.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StatusEntity{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", pubTime=" + pubTime +
                ", picNum=" + picNum +
                ", picIds='" + picIds + '\'' +
                '}';
    }
}
