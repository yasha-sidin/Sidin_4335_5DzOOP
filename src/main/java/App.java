import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Controller.Controller;
import Controller.iGetModel;
import Controller.iGetView;
import Model.FileModel;
import Model.*;
import Model.Student;
import View.*;

public class App {
    public static void main(String[] args) throws Exception {
        Student s1 = new Student("Сергей", "Иванов", 21, 101);
        Student s2 = new Student("Андрей", "Сидоров", 22, 111);
        Student s3 = new Student("Иван", "Петров", 22, 121);
        Student s4 = new Student("Игорь", "Иванов", 23, 301);
        Student s5 = new Student("Даша", "Цветкова", 25, 171);
        Student s6 = new Student("Лена", "Незабудкина", 23, 104);

        List<Student> students = new ArrayList<Student>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);

        HashMap<Long, Student> studentsMap = new HashMap<>();
        studentsMap.put(0L, s1);
        studentsMap.put(1L, s2);
        studentsMap.put(2L, s3);
        studentsMap.put(3L, s4);
        studentsMap.put(4L, s5);
        studentsMap.put(5L, s6);

        FileModel fModel = new FileModel("StudentsDB.txt");
        fModel.saveAllStudentToFile(students);
        iGetModel newFModel = fModel;

        iGetModel model = new Model(students);
        iGetModel hModel = new HashModel(studentsMap);

        iGetView view = new ViewEng();

        Controller controller = new Controller(view, fModel);
        controller.run();

    }
}