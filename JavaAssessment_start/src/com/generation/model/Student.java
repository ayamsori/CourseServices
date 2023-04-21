package com.generation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Student extends Person
{
    public static final double PASS_MIN_GRADE = 3.0;

    private final HashMap<String, EnrolledCourse> enrolledCourses = new HashMap<>();


    public Student( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate );
    }

    public boolean enrollToCourse( Course course )
    {
        //TODO Check if student has already enrolled to the course, if not add the course to enrolledCourses hashmap
        if (!enrolledCourses.containsKey(course.getCode())) {
            // Add the course to the enrolledCourses HashMap
            enrolledCourses.put(course.getCode(), new EnrolledCourse(course));
            return true;
        }
       return false;
    }

    public HashMap<String, EnrolledCourse> getEnrolledCourses()
    {
        //TODO return a Hashmap of all the enrolledCourses
        return enrolledCourses;
    }

    public void gradeCourse( String courseCode, double grade )
    {
        //TODO set the grade for the enrolled Course
        if (enrolledCourses.containsKey(courseCode)) {
            EnrolledCourse enrolledCourse = enrolledCourses.get(courseCode);
            // Set the grade for the enrolledCourse
            enrolledCourse.setGrade(grade);
        } else {
            // If the given courseCode is not found in enrolledCourses, print an error message
            System.out.println("Error: Course with code " + courseCode + " not found.");
        }
    }

    public Course findCourseById( String courseId )
    {
        //TODO return a Course from the course Id
        // Get the enrolled courses for the student
        HashMap<String, EnrolledCourse> enrolledCourses = getEnrolledCourses();
        // Return the EnrolledCourse object with the specified courseId if it exists, otherwise return null
        return enrolledCourses.get(courseId);
    }

    public HashMap<String, EnrolledCourse> findPassedCourses()
    {
        //TODO Check the enrolled courses grade and compare to the passing grade
        HashMap<String, EnrolledCourse> passedCourses = new HashMap<>();
        double passingGrade = 3.0; // Minimum passing grade is 3.0

        for (EnrolledCourse enrolledCourse : enrolledCourses.values()) {
            if (enrolledCourse.getGrade() >= passingGrade) {
                passedCourses.put(enrolledCourse.getCode(), enrolledCourse);
            }
        }

        return passedCourses;
    }

    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }
}
