package pairmatching.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.model.Mission;
import pairmatching.model.Pair;

public class PairHistory {
    private final Course course;
    private final Level level;
    private final Mission mission;
    private final List<Pair> pairs;

    public PairHistory(Course course, Level level, Mission mission, List<Pair> pairs) {
        this.course = course;
        this.level = level;
        this.mission = mission;
        this.pairs = pairs;
    }

    public boolean equalLevel(Level level){
        return this.level.equals(level);
    }

    public List<Pair> getPairs() {
        return pairs;
    }
}
