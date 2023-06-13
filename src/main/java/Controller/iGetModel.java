package Controller;

import Model.Student;

import java.util.Collections;
import java.util.List;

public interface iGetModel{
    /**
     *
     * @return current class list of Students
     */
    public List getAllStudents();

    /**
    *
    * @return size of model
    */
    public int size();

    /**
    *
    * @return delete student by his number or output info about existing of student with this number
    */
    public void delete(int studentNum);
}
