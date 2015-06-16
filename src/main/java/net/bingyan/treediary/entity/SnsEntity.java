package net.bingyan.treediary.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by ilovey on 5/15/15.
 */
@Entity
@Table(name = "sns", schema = "", catalog = "treediary")
public class SnsEntity {
    private int id;
    private String snsType;
    private String nickname;
    private String headUrl;
    private String openId;
    private Timestamp createTime;

    public SnsEntity(){

    }

    public SnsEntity(String snsType, String nickname, String headUrl, String openId) {
        this.snsType = snsType;
        this.nickname = nickname;
        this.headUrl = headUrl;
        this.openId = openId;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "sns_type")
    public String getSnsType() {
        return snsType;
    }

    public void setSnsType(String snsType) {
        this.snsType = snsType;
    }

    @Basic
    @Column(name = "nickname")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "head_url")
    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    @Basic
    @Column(name = "open_id")
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SnsEntity snsEntity = (SnsEntity) o;

        if (id != snsEntity.id) return false;
        if (createTime != null ? !createTime.equals(snsEntity.createTime) : snsEntity.createTime != null) return false;
        if (headUrl != null ? !headUrl.equals(snsEntity.headUrl) : snsEntity.headUrl != null) return false;
        if (nickname != null ? !nickname.equals(snsEntity.nickname) : snsEntity.nickname != null) return false;
        if (openId != null ? !openId.equals(snsEntity.openId) : snsEntity.openId != null) return false;
        if (snsType != null ? !snsType.equals(snsEntity.snsType) : snsEntity.snsType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (snsType != null ? snsType.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (headUrl != null ? headUrl.hashCode() : 0);
        result = 31 * result + (openId != null ? openId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SnsEntity{" +
                "id=" + id +
                ", snsType='" + snsType + '\'' +
                ", nickname='" + nickname + '\'' +
                ", headUrl='" + headUrl + '\'' +
                ", openId='" + openId + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
