package com.nathansbud.Classes;
import java.util.Calendar;

public class School {
    private Student directory[];
    private String name;
    private int foundYear;

    private Calendar calendar = Calendar.getInstance();

    School() {
        name = "";

    }

    School(String _name, String[] _studentNames, int _foundYear) {
        directory = new Student[_studentNames.length];
        for(int i = 0; i < directory.length; i++) {
            directory[i] = new Student(_studentNames[i], 11, 16);
        }
    }

    public int getFoundYear() {
        return foundYear;
    }
    public int getAge() {return foundYear - calendar.get(Calendar.YEAR);}

    public void addStudent(Student newStudent) {
        Student s[] = new Student[directory.length + 1];
        for(int i = 0; i < directory.length; i++) {
            s[i] = directory[i];
        }
        s[s.length - 1] = newStudent;
        directory = s;
    }
    public void removeStudent(int index) {
        Student s[] = new Student[directory.length - 1];
        for(int i = 0; i < index; i++) {
            s[i] = directory[i];
        }

        for(int i = index; i < s.length; i++) {
            s[i] = directory[i + 1];
        }

        directory = s;
    }
    public void removeStudentById(int idIndex) {
        int index = -1;
        for(int i = 0; i < directory.length; i++) {
            if(directory[i].getStudentID() == idIndex) {
                index = i;
            }
        }

        if(index >= 0) {
            System.out.println("Student with ID #" + idIndex + ", " + directory[index].getFirstName() + " " + directory[index].getLastName() + " has been removed from the Directory");
            removeStudent(index);
        } else {
            System.out.println("A student with ID #" + idIndex + " does not exist in the Directory");
        }
    }


    public Student[] getDirectory() {
        return directory;
    }
    public Student getStudent(int index) {
        return directory[index];
    }
}
