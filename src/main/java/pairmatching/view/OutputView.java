package pairmatching.view;

import java.util.List;
import pairmatching.model.Pair;
import pairmatching.service.PairHistory;

public class OutputView {
    public void printPairMatching(){
        System.out.println("\n#############################################");
        System.out.println("과정 : 백엔드 | 프론트엔드");
        System.out.println("미션 :");
        System.out.println("  - 레벨1: 자동차경주 | 로또 | 숫자야구게임");
        System.out.println("  - 레벨2: 장바구니 | 결제 | 지하철노선도");
        System.out.println("  - 레벨3: ");
        System.out.println("  - 레벨4: 성능개선 | 배포");
        System.out.println("  - 레벨5: ");
        System.out.println("#############################################");
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");
    }

    public void printPairMatchingResult(PairHistory pairHistory){
        System.out.println("페어 매칭 결과 입니다.");

        if (pairHistory == null){
            System.out.println("[ERROR] 매칭 이력이 없습니다.\n");
            return;
        }

        List<Pair> pairList = pairHistory.getPairs();

        for (Pair pair : pairList){
            System.out.println(pair.getCrew1() + " : " + pair.getCrew2());
        }
        System.out.println();
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

}
