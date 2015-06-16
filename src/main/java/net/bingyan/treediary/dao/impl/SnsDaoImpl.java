package net.bingyan.treediary.dao.impl;

import net.bingyan.treediary.dao.ISnsDao;
import net.bingyan.treediary.entity.SnsEntity;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by ilovey on 5/15/15.
 */

@Repository
@Transactional
public class SnsDaoImpl implements ISnsDao{
    private @Autowired SessionFactory sessionFactory;

    @Override
    @Transactional
    public SnsEntity findBySnsId(Integer snsId) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        SnsEntity snsEntity = (SnsEntity)session.get(SnsEntity.class, snsId);
        session.getTransaction().commit();
        return snsEntity;
    }

    @Override
    public Integer save(SnsEntity snsEntity) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(snsEntity);
        session.getTransaction().commit();
        return snsEntity.getId();
    }

    @Override
    public SnsEntity findByOpenId(String openId, String snsType) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from SnsEntity as m where m.openId = ? and snsType = ?");
        query.setString(0, openId);
        query.setString(1, snsType);
        SnsEntity se = (SnsEntity)query.uniqueResult();
        session.getTransaction().commit();
        return se;
    }

    @Override
    public Serializable insert(String snsType, String nickname, String headUrl, String openId, Timestamp createAt){
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        SnsEntity snsEntity = new SnsEntity();
        snsEntity.setHeadUrl(headUrl);
        snsEntity.setCreateTime(createAt);
        snsEntity.setNickname(nickname);
        snsEntity.setOpenId(openId);
        snsEntity.setSnsType(snsType);
        Serializable result = session.save(snsEntity);
        session.getTransaction().commit();
        return result;
    }

    @Override
    public void update(SnsEntity snsEntity) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(snsEntity);
        session.getTransaction().commit();
    }

    @Override
    public int updateBySql(String sql) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        int result = sqlQuery.executeUpdate();
        session.getTransaction().commit();
        return result;
    }
}
