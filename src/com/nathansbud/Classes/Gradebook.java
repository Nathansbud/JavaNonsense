package com.nathansbud.Classes;

public class Gradebook {
    public static void main(String[] args) {
        String[] names = {"Zachary Amiton", "Rana Lulla", "Aryan Kothari", "Dev Khanna", "Aaryan Sanghavi", "Shaunak Shah",
                "Aroon Das", "Shailen Sheth", "Prithvi Subrahmanyam"};

        School school = new School("American School of Bombay", names, 1981);
        school.addStudent(new Student("Meme Daddy", 11, 11));
        school.removeStudentById(5);
        school.removeStudentById(5);
        school.removeStudent(5);






    }

    public void OutputGrades(String[] args) {
        String[] names = {"Zachary Amiton", "Rana Lulla", "Aryan Kothari", "Dev Khanna", "Aaryan Sanghavi", "Shaunak Shah",
                "Aroon Das", "Shailen Sheth", "Prithvi Subrahmanyam"}; //Input array of names, parsed into an array based on spaces in Student class

        String[] classes = {"English", "Math", "Physics", "CS", "Spanish", "Economics"}; //Classes, don't modify this (student class # is hardcoded at 6)

        Student[] classroom = new Student[names.length];
        int maxNameLength = 0;
        int maxClassLength = 0;
        int classAverage = 0;
        int grades[] = new int[6];

        for (int i = 0; i < classroom.length; i++) {
            classroom[i] = new Student(names[i], 16, 11);
            if (classroom[i].getNameLength(true) > maxNameLength) {
                maxNameLength = classroom[i].getNameLength(true); //Used to find the max character name, to handle spacing
            }
        }

        for(int i = 0; i < classes.length; i++) {
            if(classes[i].length() > maxClassLength) {
                maxClassLength = classes[i].length();
            }
        }


        System.out.print("ID"+"\t\t"+"Name");
        for(int i = 4; i < maxNameLength; i++) {
            System.out.print(" ");
        }
        System.out.print("\t\t");

        for(int i = 0; i < classes.length; i++) {
            System.out.print(classes[i]);
            for(int j = classes[i].length(); j < maxClassLength; j++) {
                System.out.print(" ");
            }
            System.out.print("\t");
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < classroom.length; i++) {
            if(classroom[i].getNameCount() > 1) {
                System.out.print(classroom[i].getStudentID() + "\t\t" + classroom[i].getLastName() + ", " +
                        classroom[i].getFirstName());
            } else {
                System.out.print(classroom[i].getStudentID() + "\t\t" + classroom[i].getFirstName());
            } //If student has at least 2 names, output as "Last, First", else just output "First"

            for (int j = classroom[i].getNameLength(true); j < maxNameLength; j++) {
                System.out.print(" ");
            } //Add as many spaces as the student's name is lacking, compared to maxNameLength, to bring all names up to the same spot

            System.out.print("\t\t"); //2 tabs to separate names from grades

            for (int j = 0; j < classroom[i].getClassGrades().length; j++) {
                classAverage += classroom[i].getClassGrades()[j];
                grades[j] += classroom[i].getClassGrades()[j];
                System.out.print(classroom[i].getClassGrades()[j]);
                for(int k = 0; k < (int)Math.ceil((float)maxClassLength/4); k++) {
                    System.out.print("\t");
                }
            } //Output all student's grades, with tabs between

            //Output total student score over max score, followed by student average rounded to 2 decimal places
            System.out.print(classroom[i].getClassGradeSum() + "/" + classroom[i].getClassGrades().length * 7 + "\t"
                    + "(Avg: " + Math.round((float) classroom[i].getClassGradeSum() / classroom[i].getClassGrades().length * 100.0) / 100.0 + ")");
            System.out.println();
        }
        System.out.println();
        for(int i = 0; i < grades.length; i++) {
            System.out.println(classes[i]+" Average: " + Math.round((float)grades[i]/classroom.length * 100)/100.0);
        }
        System.out.println();
        System.out.println("IB Score Average: " + Math.round((float) classAverage / classroom.length * 100.0) / 100.0);
    }
}

