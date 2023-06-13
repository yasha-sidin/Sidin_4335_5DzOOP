package Controller;

import Model.HashModel;
import Model.Student;

import java.util.*;

public class Controller {
    private iGetView view;
    private iGetModel model;
    private List students;

    /**
     * @param view  view part of MVP project
     * @param model model part of MVP project
     * @return init new Controller
     */
    public Controller(iGetView view, iGetModel model) {
        this.view = view;
        this.model = model;
        this.students = model.getAllStudents();
    }

    /**
     *
     * Assign students from model to students in this class
     */
    public void getAllStudents() {
        students = model.getAllStudents();
    }

    /**
     *
     * @return checking is students list empty or not
     */
    public boolean testData() {
        if (model.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * Print all students or not in depending on testData
     */
    public void update() {
        //MVP
        getAllStudents();
        if (testData()) {
            view.printAllStudents(students);
        } else {
            System.out.println("Список студентов пуст!");
        }

        //MVC
        //view.printAllStudents(model.getAllStudents());
    }

    /**
     *
     * Start using data in file
     */
    public void run() {
        Commands com = Commands.NONE;
        boolean getNewIteration = true;
        while (getNewIteration) {
            String command = view.prompt("Введите команду:");
            com = Commands.valueOf(command.toUpperCase());
            switch (com) {
                case EXIT:
                    getNewIteration = false;
                    view.exit();
                    break;
                case LIST:
                    update();
                    break;
                case DELETE:
                    getAllStudents();
                    int studentNum = Integer.parseInt(view.prompt("Введите номер студента: "));
                    boolean result = model.delete(studentNum);
                    view.didWeDelete(result);
            }

        }
    }

}
