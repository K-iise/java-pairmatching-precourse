package pairmatching;

import java.io.IOException;
import java.util.List;
import pairmatching.controller.Controller;
import pairmatching.model.Course;
import pairmatching.model.Crew;
import pairmatching.service.CrewReader;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Application {
    public static void main(String[] args){
        // TODO 구현 진행

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Controller controller = new Controller(inputView, outputView);

        controller.run();
    }
}
