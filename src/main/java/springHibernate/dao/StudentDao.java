package springHibernate.dao;

import springHibernate.domain.Student;

import java.util.List;

/**
 * Created by liuyang on 2017/6/24.
 */
public interface StudentDao {
    List<Student> findAllStudent();
}
