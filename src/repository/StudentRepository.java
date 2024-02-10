package repository;

import org.hibernate.Session;

import entity.StudentEntity;

public class StudentRepository {

    public Integer save(StudentEntity studentEntity, Session session) throws Exception {
        Integer id = (Integer) session.save(studentEntity);
        return id;
    }

}
