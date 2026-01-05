package pairmatching.service;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import pairmatching.model.Course;
import pairmatching.model.Crew;

public class CrewReader {
    public List<String> readCrewFile(Course course) throws IOException {
        String courseName = checkCourse(course);
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        getClass().getClassLoader().getResourceAsStream(courseName)
                )
        );
        String data;
        List<String> crewList = new ArrayList<>();
        while ((data=br.readLine()) != null) {
            crewList.add(data);
        }
        return crewList;
    }

    private String checkCourse(Course course){
        if (course.equals(Course.BACKEND)){
            return "backend-crew.md";
        }
        return "frontend-crew.md";
    }
}
