import com.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class TestH {
    @Test
    public void test1() {

        Configuration cf = new Configuration().configure();

        @SuppressWarnings("deprecation")
        SessionFactory sf = cf.buildSessionFactory();

        Session session = sf.openSession();
        //开启事务，并获得操作事务的对象
        Transaction tx = session.beginTransaction();
        //关于数据库的操作都在下面进行---------------------------------------

        // 增加一条记录
        UserEntity user = new UserEntity();
        user.setName("111");
        user.setSex("222");
        session.save(user);

        //提交事务，关于数据库的操作都在上面进行-------------------------------------------
        tx.commit();
        session.close();
        sf.close();
    }
}
