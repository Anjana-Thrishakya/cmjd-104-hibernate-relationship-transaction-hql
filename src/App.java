import org.hibernate.Session;

import dto.StudentDto;
import entity.StudentEntity;
import service.StudentService;
import util.SessionFactoryConfiguration;

public class App {
    public static void main(String[] args) throws Exception {
        StudentDto studentDto = new StudentDto("Stu 1", "Address 1","HP", "Pro Book", 1);
        StudentService studentService = new StudentService();
        String resp = studentService.saveStudent(studentDto);
        System.out.println(resp);
    }
}
