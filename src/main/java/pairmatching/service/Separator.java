package pairmatching.service;

public class Separator {
    public String[] splitByPairCondition(String input){
        String token = ",";
        return input.split(token);
    }
}
