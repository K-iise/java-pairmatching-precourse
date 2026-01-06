package pairmatching.controller;

import java.io.IOException;
import java.util.List;
import org.mockito.stubbing.ValidableAnswer;
import pairmatching.model.Course;
import pairmatching.model.Crew;
import pairmatching.model.MatchInfo;
import pairmatching.service.CrewReader;
import pairmatching.service.PairHistory;
import pairmatching.service.PairService;
import pairmatching.service.Validator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private final Validator validator;
    private final PairService pairService;
    public Controller(InputView inputView, OutputView outputView, Validator validator, PairService pairService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.validator = validator;
        this.pairService = pairService;
    }

    public void run() {
        while (true) {
            // 기능 선택
            String choice = loopChoice();
            
            // 페어 매칭
            if (choice.equals("1")){
                proceedMatching();
            }
            
            // 페어 조회
            if (choice.equals("2")){
                // 과정, 레벨, 미션 입력
                String condition  = loopPairCondition();

                // 페어 매칭 후 출력
                MatchInfo matchInfo = MatchInfo.from(condition);

                // 페어 매칭 조회
                PairHistory pairHistory = pairService.getPairHistory(matchInfo);
                outputView.printPairMatchingResult(pairHistory);
            }
            
            // 페어 초기화
            if (choice.equals("3")){
                pairService.clearPairHistory();
            }
            
            // 종료
            if (choice.equals("Q")){
                break;
            }
        }

    }

    private void proceedMatching() {
        while (true){
            // 과정, 레벨, 미션 입력
            String condition  = loopPairCondition();
            // 이전 매칭 조회
            MatchInfo matchInfo = MatchInfo.from(condition);
            PairHistory pairHistory = pairService.getPairHistory(matchInfo);

            if (pairHistory != null){
                String answer = inputView.readReMatching();
                if (answer.equals("아니오")) {
                    continue; // 다시 '과정, 레벨, 미션' 입력으로 돌아감
                }
                pairService.removePairHistory(matchInfo);
            }

            // 매칭 진행 (새 매칭 '네'를 누른 경우)
            pairService.pairMatching(matchInfo);
            PairHistory result = pairService.getPairHistory(matchInfo);
            outputView.printPairMatchingResult(result);
            break; // 매칭 완료 시 '기능 선택' 메뉴로 탈출
        }
    }

    private String loopChoice(){
        while (true){
            try {
                String choice = inputView.readData();
                validator.validateChoice(choice);
                return choice;
            } catch (IllegalArgumentException e){
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private String loopPairCondition(){
        while (true) {
            try {
                String pairCondition = inputView.readPair();
                validator.validatePairCondition(pairCondition);
                return pairCondition;
            } catch (IllegalArgumentException e){
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

}
