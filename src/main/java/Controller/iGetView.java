package Controller;

import Model.Student;

import java.util.*;

public interface iGetView {
    /**
     *
     * @param  students list of Students
     * @return print list of this Students
     */
    void printAllStudents(List students);

    /**
     *
     * @param  message message which will accompany the text input
     * @return input construction by using Scanner
     */
    String prompt(String message);

    /**
     *
     * @param  result true or false in depending on existing of Student in List
     * @return print result of deleting
     */
    void didWeDelete(boolean result);

    /**
     *
     * Print info about exit from program
     */
    void exit();
}
