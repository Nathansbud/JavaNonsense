package com.nathansbud.Classes;
import java.util.Random;

public class Student {
    private static int id = 1;

    private String[] names;

    private int age;
    private int grade;

    private int studentID;
    private String userName;

    private String[] classNames;
    private int[] classGrades;


    Student() {
        names = new String[2];
        names[0] = "John";
        names[1] = "Smith";

        age = 0;
        grade = 0;
        userName = "UserName";
        studentID = id++;
    }

    Student(String _name, int _age, int _grade) {
        studentID = id++; //Each student's ID is simply the next ID in line, assigns new student an id then increments the static counter

        names = _name.split("\\s");
        age = _age;
        grade = _grade;

        classGrades = new int[6];
        classNames = new String[6];

        for(int i = 0; i < 6; i++) {
            classGrades[i] = (int)(Math.random() * 7 + 1);
        }
    }

    Student(String _name, int _age, int _grade, String[] _classNames, int[] _classGrades) {
        studentID = id++;

        age = _age;
        grade = _grade;

        names = _name.split("\\s");

        classNames = _classNames;
        classGrades = _classGrades;

    } //Constructor with support for inputting class names/grades


    public int getAge() {
        return age;
    }
    public void setAge(int _age) {age = _age;}

    public String getName(int index) {
        if(index < names.length) {
            return names[index];
        } else return names[names.length - 1];
    } //Returns student name called by index; if index greater than max of bound, returns last name instead
    public int getNameCount() {
        return names.length;
    } //Returns # of student names

    public int getNameLength(boolean justFirstAndLast) {
        int nameLength = 0;
        if(names.length > 1) {
            if (justFirstAndLast) {
                nameLength = names[0].length() + names[names.length - 1].length() + 1; //Get length of first & last name + space between them
            } else {
                for (int i = 0; i < names.length; i++) {
                    nameLength += names[i].length();
                }
                nameLength += names.length - 1;
            } //Get length of all student names + spaces between them
        } else {
            nameLength = names[0].length();
        }
        return nameLength;
    } //Returns # of characters in a student's name(s)

    //G/S for first & last name, as they are the most commonly called
    public String getFirstName() {
        return names[0];
    }
    public void setFirstName(String _firstName) {
        names[0] = _firstName;
    }

    public String getLastName() {
        return names[names.length - 1];
    }
    public void setLastName(String _lastName) {
        names[names.length - 1] = _lastName;
    }



    public int getStudentID() {
        return studentID;
    }
    public static int getLastID() {
        return id;
    }

    public int getGrade() {
        return grade;
    }
    public void setGrade(int _grade) {
        grade = _grade;
    }

    public int[] getClassGrades() {
        return classGrades;
    }
    public void setClassNames(String[] _classNames) {
        classNames = _classNames;
    }
    public int getClassGradeSum() {
        int sum = 0;
        for(int i = 0; i < classGrades.length; i++) {
            sum += classGrades[i];
        }
        return sum;
    }
}
