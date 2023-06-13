package Model;

import Controller.iGetModel;

import java.util.*;

public class HashModel implements iGetModel {
    private HashMap<Long, Student> students;
    public HashModel(HashMap<Long, Student> students) {
        this.students = students;
    }
    public List getAllStudents() {
        List listStud = new ArrayList<>();
        Object[] keys = students.keySet().toArray();
        Object[] values = students.values().toArray();
        for(int i = 0; i < students.size(); i++) {
            Object[] keyValue = new Object[2];
            keyValue[0] = keys[i];
            keyValue[1] = values[i];
            List temp = new ArrayList<>(Arrays.asList(keyValue));
            listStud.add(temp);
        }
        return listStud;
    }

    @Override
    public int size() {
        return students.size();
    }

    @Override
    public boolean delete(int studentNum) {
        List<List> studList = getAllStudents();
        for(int i = 0; i < studList.size(); i++) {
            Student temp = (Student) studList.get(i).get(1);
            if (temp.getId() == studentNum) {
                students.remove(studList.get(i).get(0));
                return true;
            }
        }
        return false;
    }
}
