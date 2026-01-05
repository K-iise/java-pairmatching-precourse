package pairmatching.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validator {

    public void validateChoice(String choice){
        List<String> choiceList = Arrays.asList("1","2","3","Q");
        if (!choiceList.contains(choice)){
            throw new IllegalArgumentException("[Error] 유효하지 않은 기능입니다. 다시 입력해 주세요.");
        }
    }
}
