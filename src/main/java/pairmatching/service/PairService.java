package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import pairmatching.model.Course;
import pairmatching.model.Crew;
import pairmatching.model.Level;
import pairmatching.model.Mission;
import pairmatching.model.Pair;

public class PairService {

    private CrewReader crewReader;
    private PairGenerator pairGenerator;
    private List<PairHistory> pairHistoryList = new ArrayList<>();

    public void pairMatching(Course course, Level level, Mission mission) throws IOException {
        List<String> crewList = crewReader.readCrewFile(course);

        int tryCount = 0;

        while (tryCount > 3) {
            tryCount++;

            // 크루 이름 랜덤 섞기
            List<String> shuffledCrew = Randoms.shuffle(crewList);
            // 페어 리스트 생성
            List<Pair> pairList = pairGenerator.getPairList(shuffledCrew);

            // 페어 검증
            if (checkDuplicationValidate(pairList, course, level)) {
                // 성공 → 히스토리 저장
                pairHistoryList.add(new PairHistory(course, level, mission, pairList));
                return;
            }
        }

        throw new IllegalStateException("페어 매칭에 실패했습니다.");
    }

    private boolean checkDuplicationValidate(List<Pair> pairList, Course course, Level level){
        if (pairHistoryList.isEmpty()) {
            return true;
        }
        for (PairHistory pairHistory : pairHistoryList){
            if (pairHistory.equalLevel(level)){
                List<Pair> pairs = pairHistory.getPairs();
                for (Pair p : pairs){
                    if (pairList.contains(p)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
