package pairmatching;

import java.io.IOException;
import java.util.List;
import javax.xml.bind.ValidationEvent;
import pairmatching.controller.Controller;
import pairmatching.model.Course;
import pairmatching.model.Crew;
import pairmatching.service.CrewReader;
import pairmatching.service.Validator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Application {
    public static void main(String[] args){
        // TODO 구현 진행

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Validator validator = new Validator();
        Controller controller = new Controller(inputView, outputView, validator);

        controller.run();
    }
}
