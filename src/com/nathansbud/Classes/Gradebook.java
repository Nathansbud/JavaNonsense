package com.nathansbud.Classes;

/*

Read in from an array of names.
Generate students for each name.
Output ALL students Info (one per line)
Calculate the total average grade of all subjects and Total Grade.
Output averages below student info

*/

public class Gradebook {

    public static void main(String[] args) {
        String[] names = {"Zachary Amiton", "Rana Lulla", "Aryan Kothari", "Dev Khanna", "Aaryan Sanghavi", "Shaunak Shah",
                "Aroon Das", "Shailen Sheth", "Prithvi Subrahmanyam"}; //Input array of names, parsed into an array based on spaces in Student class

        String[] classes = {"English", "Math", "Physics", "CS", "Spanish", "Econ"}; //Classes, don't modify this (student class # is hardcoded at 6)

        Student[] classroom = new Student[names.length];
        int maxNameLength = 0;

        for (int i = 0; i < classroom.length; i++) {
            classroom[i] = new Student(names[i], 16, 11);
            if (classroom[i].getNameLength(true) > maxNameLength) {
                maxNameLength = classroom[i].getNameLength(true); //Used to find the max character name, to handle spacing
            }
        }

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
                System.out.print(classroom[i].getClassGrades()[j] + "\t");
            } //Output all student's grades, with tabs between

            //Output total student score over max score, followed by student average rounded to 2 decimal places
            System.out.print(classroom[i].getClassGradeSum() + "/" + classroom[i].getClassGrades().length * 7 + "\t"
                    + "(Avg: " + Math.round((float) classroom[i].getClassGradeSum() / classroom[i].getClassGrades().length * 100.0) / 100.0 + ")");
            System.out.println();
        }
    }
}

