package pairmatching.service;

import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;
import pairmatching.model.Course;
import pairmatching.model.Crew;

public class CrewReaderTest {
    private CrewReader crewReader;

    @Test
    public void 크루_이름_읽기_테스트() throws IOException {
        crewReader = new CrewReader();
        List<String> crewList = crewReader.readCrewFile(Course.BACKEND);

        for (String crew : crewList){
            System.out.println(crew);
        }
    }
}
