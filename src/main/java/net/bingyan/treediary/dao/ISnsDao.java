package net.bingyan.treediary.dao;

import net.bingyan.treediary.entity.SnsEntity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by ilovey on 5/15/15.
 */
public interface ISnsDao {
    public SnsEntity findBySnsId(Integer snsId);
    public Integer save(SnsEntity snsEntity);
    public SnsEntity findByOpenId(String openId, String snsType);
    public Serializable insert(String snsType, String nickname, String headUrl, String openId, Timestamp createAt);
    public void update(SnsEntity snsEntity);
    public int updateBySql(String sql);
}
