package net.bingyan.treediary.service;

import net.bingyan.treediary.entity.SnsEntity;

import java.sql.SQLException;

/**
 * Created by ilovey on 5/15/15.
 */
public interface ISnsService {
    public SnsEntity loginUser(SnsEntity snsEntity);

    public SnsEntity findBySnsId(Integer snsId);
    public SnsEntity findByOpenId(String OpenId, String snsType);
}
