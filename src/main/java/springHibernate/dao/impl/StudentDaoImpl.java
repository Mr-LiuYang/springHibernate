package springHibernate.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.orm.hibernate5.SessionFactoryUtils;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springHibernate.dao.StudentDao;
import springHibernate.domain.Student;

import java.util.List;


/**
 * Created by liuyang on 2017/6/24.
 */
@Repository
public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao {
    private static final Logger logger= LoggerFactory.getLogger(StudentDaoImpl.class);

   @Autowired
   private SessionFactory sessionFactory;

   public Session getSession(){
       return sessionFactory.openSession();
   }

    @Override
    @Cacheable("studentCache")
    @Transactional(readOnly = true)
    public List<Student> findAllStudent() {
       logger.debug("查询所有学生");
        return  getSession().createQuery("select s from Student s",Student.class).getResultList();
    }
}
