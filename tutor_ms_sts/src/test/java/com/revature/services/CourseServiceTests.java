package com.revature.services;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Course;

@SpringBootTest(classes = com.revature.app.TutorMsStsApplication.class)
@Transactional
public class CourseServiceTests {

    @Autowired
    public CourseService cs;

    @Test
    void addCourseTest() {
        Course newCourse = new Course(
                "Introduction to Biology: The Evolution and Diversity of Life",
                "BIOL", 1010, 3);
        newCourse = cs.addCourse(newCourse);
        assertNotEquals(0, newCourse.getId());
    }

    @Test
    void getAllCoursesTest() {
        List<Course> allCourses = cs.getAllCourses();
        assertFalse(allCourses.isEmpty());
    }
    
    @Test
    void getCourseByNameTest() {
        Course expectedCourse = new Course(1, "Composition I", "ENGL", 1101, 3);
        Course actualCourse = cs.getCourse("Composition I");
        assertEquals(expectedCourse.toString(), actualCourse.toString());
        assertNull(cs.getCourse("Keelhauling 101"));
    }

    @Test
    void getCourseByIdTest() {
        Course expectedCourse = new Course(1, "Composition I", "ENGL", 1101, 3);
        Course actualCourse = cs.getCourse(1);
        assertEquals(expectedCourse.toString(), actualCourse.toString());
        Course notACourse = cs.getCourse(100);
        assertNull(notACourse);
    }

    @Test
    void updateCourseTest() {
        Course course = cs.getCourse(2);
        String courseToUpdateString = course.toString();
        int courseToUpdateId = course.getId();
        course.setName("Poetry");
        course.setLevel(1105);
        course = cs.updateCourse(course);
        assertEquals(courseToUpdateId, course.getId());
        assertNotEquals(courseToUpdateString, course.toString());
        Course fakeCourse = new Course();
        assertNull(cs.updateCourse(fakeCourse));
    }

    @Test
    void deleteCourseTest() {
        boolean cDeleted = cs.deleteCourse(3);
        assertTrue(cDeleted);
        assertThrows(EmptyResultDataAccessException.class, () -> {
            cs.deleteCourse(100);
        });
    }

}
