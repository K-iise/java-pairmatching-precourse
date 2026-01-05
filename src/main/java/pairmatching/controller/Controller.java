package pairmatching.controller;

import java.io.IOException;
import java.util.List;
import pairmatching.model.Course;
import pairmatching.model.Crew;
import pairmatching.service.CrewReader;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Controller {

    private InputView inputView;
    private OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        String choice = inputView.readData();
        outputView.printPairMatching();

    }

}
