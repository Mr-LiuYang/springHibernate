package springHibernate.service;

import org.springframework.stereotype.Service;
import springHibernate.domain.Student;

import java.util.List;

/**
 * Created by liuyang on 2017/6/24.
 */

public interface StudentService {
    List<Student> findAllStudent();
}
