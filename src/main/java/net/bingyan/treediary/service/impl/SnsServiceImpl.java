package net.bingyan.treediary.service.impl;

import net.bingyan.treediary.dao.ISnsDao;
import net.bingyan.treediary.entity.SnsEntity;
import net.bingyan.treediary.service.ISnsService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Created by ilovey on 5/15/15.
 */


@Service("iSnsService")
public class SnsServiceImpl implements ISnsService{
    private @Autowired ISnsDao snsDao;

    @Override
    public SnsEntity loginUser(SnsEntity snsEntity) {
        SnsEntity se = snsDao.findByOpenId(snsEntity.getOpenId(), snsEntity.getSnsType());
        System.out.println(se);
        if(se == null){
            snsEntity.setCreateTime(new Timestamp(System.currentTimeMillis()));
            Integer snsId = snsDao.save(snsEntity);
            snsEntity.setId(snsId);
            return snsEntity;
        }
        return se;
    }

    @Override
    public SnsEntity findBySnsId(Integer snsId) {
        return  snsDao.findBySnsId(snsId);
    }

    @Override
    public SnsEntity findByOpenId(String OpenId, String snsType) {
        return snsDao.findByOpenId(OpenId, snsType);
    }
}
