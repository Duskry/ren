package com.daoImpl;

import com.dao.UserDao;
import com.entity.UserEntity;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
@Repository
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
    @Resource
    public void setSessionFacotry(SessionFactory sessionFacotry) {
        super.setSessionFactory(sessionFacotry);
    }

    @Override
    public UserEntity login(UserEntity user) {

        String hql = "from UserEntity where name = :name and sex = :sex";
        Session session = this.getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        query.setParameter("name", user.getName());
        query.setParameter("sex", user.getSex());
        System.out.println(user.getName());
        System.out.println(user.getSex());
        UserEntity result = (UserEntity) query.uniqueResult();
        return result;
    }
}
