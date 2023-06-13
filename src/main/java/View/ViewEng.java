package View;

import Controller.iGetView;
import Model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ViewEng implements iGetView {
    @Override
    public void printAllStudents(List students) {
        System.out.println("------------List output------------");
        for(var stud: students) {
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

    @Override
    public void didWeDelete(boolean result) {
        if (result == false) {
            System.out.println("Student with this id exist");
        }
    }

    @Override
    public void exit() {
        System.out.println("You exited from program!"); 
    }
}
