package springHibernate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springHibernate.dao.StudentDao;
import springHibernate.domain.Student;
import springHibernate.service.StudentService;

import java.util.List;

/**
 * Created by liuyang on 2017/6/24.
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public List<Student> findAllStudent() {
        return studentDao.findAllStudent();
    }
}
