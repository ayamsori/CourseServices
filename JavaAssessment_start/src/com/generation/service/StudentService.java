package com.generation.service;

import com.generation.model.Course;
import com.generation.model.EnrolledCourse;
import com.generation.model.Student;

import java.util.HashMap;

public class StudentService
{
    private final HashMap<String, Student> students = new HashMap<>();

    public void registerStudent( Student student )
    {
        //TODO Add new student to the students hashmap
        // Add the student to the hashmap
        students.put(student.getId(), student);
    }

    public Student findStudent( String studentId )
    {
        //TODO Find the student from the Hashmap with the student id
        // Retrieve the student from the hashmap using the student ID as the key
        return students.get(studentId);
    }

    public void enrollToCourse( String studentId, Course course )
    {
        //TODO check if students hashmap contains the studentsId, if have, add student to enrollToCourse
        if (students.containsKey(studentId)) {
            // If studentId exists, get the student object from the hashmap
            Student student = students.get(studentId);
            // Add the course to the enrolled courses for the student
            student.enrollToCourse(course);
            System.out.println("Student " + studentId + " enrolled to course " + course.getName());
        } else {
            System.out.println("Student " + studentId + " not found in the registry.");
        }
    }

    public void showSummary()
    {
        //TODO Loop through students hashmap and print out students' details including the enrolled courses
        for (Student student : students.values()) {
            // Print student details
            System.out.printf("Student ID: %s%nName: %s%nDOB: %s%nCourses enrolled: %n",
                    student.getId(), student.getName(), student.getBirthDate());
            HashMap<String, EnrolledCourse> enrolledCourses = student.getEnrolledCourses();
            if (enrolledCourses.isEmpty()) {
                System.out.println("None");
            } else {
                for (EnrolledCourse enrolledCourse : enrolledCourses.values()) {
                    System.out.println("- " + enrolledCourse.getCode());
                }
            }
        }
    }

    public HashMap<String, EnrolledCourse> enrolledCourses(Student student)
    {
        //TODO return a HashMap of all the enrolledCourses

        return student.getEnrolledCourses();
    }

    public Course findEnrolledCourse( Student student, String courseId )
    {
        //TODO return the course enrolled by the student from the course Id
        // Get the enrolled courses for the student
        HashMap<String, EnrolledCourse> enrolledCourses = student.getEnrolledCourses();

        // Find and return the course enrolled by the student using the courseId
        if (enrolledCourses.containsKey(courseId)) {
            return enrolledCourses.get(courseId);
        }
        return null;
    }

    public void gradeStudent(Student student, Course course, double grade) {
        student.gradeCourse(course.getCode(), grade);
    }



    public HashMap<String, EnrolledCourse> getPassedCourses(Student student) {
        return student.findPassedCourses();
    }
}
