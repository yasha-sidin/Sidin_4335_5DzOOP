package Model;

import Controller.iGetModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class FileModel implements iGetModel {
    private String fileName;

    /**
     *
     * @param  fileName name of new file
     * @return init FileModel
     */
    public FileModel(String fileName) {
        this.fileName = fileName;

        try (FileWriter fw = new FileWriter(fileName, true)) {
            fw.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     *
     * @return new students list by reading file
     */
    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<Student>();
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                String[] param = line.split(" ");
                Student pers = new Student(param[0], param[1], Integer.parseInt(param[2]), Integer.parseInt(param[3]));
                students.add(pers);
                line = reader.readLine();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return students;
    }

    @Override
    public int size() {
        return getAllStudents().size();
    }

    /**
     *
     * @param  students list of students
     * @return save list of Students in file
     */
    public void saveAllStudentToFile(List<Student> students) {
        try(FileWriter fw = new FileWriter(fileName, false)) {
            for (Student pers : students) {
                fw.write(pers.getFirstName() + " " + pers.getSecondName() + " " + pers.getAge() + " " + pers.getId());
                fw.append('\n');
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean delete(int studentNum) {
        List<Student> studList = getAllStudents();
        for (Student student : studList) {
            if (student.getId() == studentNum) {
                studList.remove(student);
                saveAllStudentToFile(studList);
                return true;
            }
        }
        return false;
    }
}


