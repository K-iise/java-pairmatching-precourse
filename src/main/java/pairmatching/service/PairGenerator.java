package pairmatching.service;

import java.util.ArrayList;
import java.util.List;
import pairmatching.model.Pair;

public class PairGenerator {
    public List<Pair> getPairList(List<String> shuffledCrew) {
        List<Pair> pairList = new ArrayList<>();
        List<String> temp = new ArrayList<>();

        for (String name : shuffledCrew) {
            temp.add(name);
            if (temp.size() == 2) {
                pairList.add(new Pair(temp.get(0), temp.get(1)));
                temp.clear();
            }
        }

        return pairList;
    }
}
