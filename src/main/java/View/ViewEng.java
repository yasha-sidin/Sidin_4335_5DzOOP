package View;

import Controller.iGetView;
import Model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ViewEng implements iGetView {
    @Override
    public void printAllStudents(List<Student> students) {
        System.out.println("------------List output------------");
        for(Object stud: (List)students) {
            System.out.println(stud);
        }
        System.out.println("------------End of list------------");
    }

    @Override
    public String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
