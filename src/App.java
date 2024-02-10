import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;

import dto.StudentDto;
import entity.BatchEntity;
import entity.StudentEntity;
import repository.BatchRepository;
import service.StudentService;
import util.SessionFactoryConfiguration;

public class App {
    public static void main(String[] args) throws Exception {
        // StudentDto studentDto = new StudentDto("Stu 1", "Address 1","HP", "Pro Book", 1);
        // StudentService studentService = new StudentService();
        // String resp = studentService.saveStudent(studentDto);
        // System.out.println(resp);

        BatchRepository batchRepository = new BatchRepository();
        List<BatchEntity> batchEntities = batchRepository.getAll(SessionFactoryConfiguration.getInstance().getSession());
        batchEntities.forEach(e-> {
            System.out.println(e);
        });

        List<Object[]> batchData = batchRepository.getAllNative(SessionFactoryConfiguration.getInstance().getSession());
        batchData.forEach(e-> {
            System.out.println(Arrays.toString(e));
        });

        List<String> batchNames = batchRepository.getAllName(SessionFactoryConfiguration.getInstance().getSession());
        batchNames.forEach(e-> {
            System.out.println(e);
        });
    }
}
