package Model;

import java.util.List;

import Controller.iGetModel;

public class Model implements iGetModel {
    private List<Student> students;

    /**
     *
     * @param  students list of Students
     * @return init new Model
     */
    public Model(List<Student> students) {
        this.students = students;
    }

    /**
     *
     * @return list of Students
     */
    public List<Student> getAllStudents()
    {
        return students;
    }

    @Override
    public int size() {
        return students.size();
    }
}