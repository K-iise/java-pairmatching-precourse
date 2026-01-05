package pairmatching.controller;

import java.io.IOException;
import java.util.List;
import org.mockito.stubbing.ValidableAnswer;
import pairmatching.model.Course;
import pairmatching.model.Crew;
import pairmatching.service.CrewReader;
import pairmatching.service.Validator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Controller {

    private InputView inputView;
    private OutputView outputView;
    private Validator validator;

    public Controller(InputView inputView, OutputView outputView, Validator validator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.validator = validator;
    }

    public void run(){
        String choice = loopChoice();
        outputView.printPairMatching();
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

}
