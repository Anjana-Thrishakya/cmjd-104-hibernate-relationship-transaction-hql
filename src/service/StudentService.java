package service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dto.StudentDto;
import entity.BatchEntity;
import entity.LaptopEntity;
import entity.StudentEntity;
import repository.BatchRepository;
import repository.LaptopRepository;
import repository.StudentRepository;
import util.SessionFactoryConfiguration;

public class StudentService {

    private BatchRepository batchRepository = new BatchRepository();
    private LaptopRepository laptopRepository = new LaptopRepository();
    private StudentRepository studentRepository = new StudentRepository();


    public String saveStudent(StudentDto dto) throws Exception{

        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            BatchEntity batchEntity = batchRepository.get(1, session);
            LaptopEntity laptopEntity = new LaptopEntity();
            laptopEntity.setBrand(dto.getBrand());
            laptopEntity.setModel(dto.getModel());
            Integer lapId = laptopRepository.save(laptopEntity, session);
            if(lapId != null){
                laptopEntity.setId(lapId);

                StudentEntity studentEntity = new StudentEntity();
                studentEntity.setAddress(dto.getAddress());
                studentEntity.setBatchEntity(batchEntity);
                studentEntity.setLaptopEntity(laptopEntity);
                studentEntity.setName(dto.getName());

                Integer stuId = studentRepository.save(studentEntity, session);
                if(stuId != null){
                    transaction.commit();
                    return "Success";
                } else {
                    transaction.rollback();
                    return "Student Save Error";
                }

            } else{
                transaction.rollback();
                return "Laptop Save Error";
            }

        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return e.getMessage();
        }

    }
}
