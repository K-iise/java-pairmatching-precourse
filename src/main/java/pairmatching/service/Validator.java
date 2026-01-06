package pairmatching.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.model.Mission;

public class Validator {

    private final Separator separator;

    public Validator(Separator separator) {
        this.separator = separator;
    }

    public void validateChoice(String choice){
        List<String> choiceList = Arrays.asList("1","2","3","Q");
        if (!choiceList.contains(choice)){
            throw new IllegalArgumentException("[Error] 유효하지 않은 기능입니다. 다시 입력해 주세요.");
        }
    }

    public void validatePairCondition(String pairChoice) {
        String[] parts= separator.splitByPairCondition(pairChoice);

        if (parts.length != 3) {
            throw new IllegalArgumentException("[ERROR] 과정, 레벨, 미션 형식으로 입력해야 합니다.");
        }

        Course course = Course.fromCourse(parts[0].trim());
        Level level = Level.fromLevel(parts[1].trim());
        Mission mission = Mission.getMissionByLevel(level, parts[2].trim());
    }
}
