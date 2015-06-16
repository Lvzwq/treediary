package net.bingyan.treediary.entity;

import javax.persistence.*;

/**
 * Created by ilovey on 5/15/15.
 */
@Entity
@Table(name = "user_detail", schema = "", catalog = "treediary")
public class UserDetailEntity {
    private int id;
    private int snsId;
    private int treeLevel;
    private int plantNum;
    private int yellow;
    private int blue;
    private int green;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "sns_id")
    public int getSnsId() {
        return snsId;
    }

    public void setSnsId(int snsId) {
        this.snsId = snsId;
    }

    @Basic
    @Column(name = "tree_level")
    public int getTreeLevel() {
        return treeLevel;
    }

    public void setTreeLevel(int treeLevel) {
        this.treeLevel = treeLevel;
    }

    @Basic
    @Column(name = "plant_num")
    public int getPlantNum() {
        return plantNum;
    }

    public void setPlantNum(int plantNum) {
        this.plantNum = plantNum;
    }

    @Basic
    @Column(name = "yellow")
    public int getYellow() {
        return yellow;
    }

    public void setYellow(int yellow) {
        this.yellow = yellow;
    }

    @Basic
    @Column(name = "blue")
    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    @Basic
    @Column(name = "green")
    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDetailEntity that = (UserDetailEntity) o;

        if (blue != that.blue) return false;
        if (green != that.green) return false;
        if (id != that.id) return false;
        if (plantNum != that.plantNum) return false;
        if (snsId != that.snsId) return false;
        if (treeLevel != that.treeLevel) return false;
        if (yellow != that.yellow) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + snsId;
        result = 31 * result + treeLevel;
        result = 31 * result + plantNum;
        result = 31 * result + yellow;
        result = 31 * result + blue;
        result = 31 * result + green;
        return result;
    }

    @Override
    public String toString() {
        return "UserDetailEntity{" +
                "id=" + id +
                ", snsId=" + snsId +
                ", treeLevel=" + treeLevel +
                ", plantNum=" + plantNum +
                ", yellow=" + yellow +
                ", blue=" + blue +
                ", green=" + green +
                '}';
    }
}
