package com.daoImpl;

import com.dao.UserDao;
import com.entity.UserEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import javax.annotation.Resource;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
    @Resource
    public void setSessionFacotry(SessionFactory sessionFacotry) {
        super.setSessionFactory(sessionFacotry);
    }

    @Override
    public UserEntity login(UserEntity user) {

        String hql = "from UserEntity where name = ? and sex = ?";
        Session session = this.getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        query.setParameter(0, user.getName());
        query.setParameter(1, user.getSex());
        UserEntity result = (UserEntity) query.uniqueResult();
        return result;
    }
}
