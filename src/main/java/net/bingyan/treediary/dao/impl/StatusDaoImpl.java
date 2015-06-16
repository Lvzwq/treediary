package net.bingyan.treediary.dao.impl;

import net.bingyan.treediary.dao.IStatusDao;
import net.bingyan.treediary.entity.StatusEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by ilovey on 5/29/15.
 */
@Repository
@Transactional
public class StatusDaoImpl implements IStatusDao {
    private @Autowired SessionFactory sessionFactory;

    @Override
    public Integer save(StatusEntity statusEntity) {
        Session session= sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(statusEntity);
        session.getTransaction().commit();
        return statusEntity.getId();
    }
}
