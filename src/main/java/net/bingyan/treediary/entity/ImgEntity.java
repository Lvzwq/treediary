package net.bingyan.treediary.entity;

import javax.persistence.*;

/**
 * Created by ilovey on 5/15/15.
 */

@Entity
@Table(name = "img", schema = "", catalog = "treediary")
public class ImgEntity {
    private int id;
    private String imgUrl;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "img_url")
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImgEntity imgEntity = (ImgEntity) o;

        if (id != imgEntity.id) return false;
        if (imgUrl != null ? !imgUrl.equals(imgEntity.imgUrl) : imgEntity.imgUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (imgUrl != null ? imgUrl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ImgEntity{" +
                "id=" + id +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
