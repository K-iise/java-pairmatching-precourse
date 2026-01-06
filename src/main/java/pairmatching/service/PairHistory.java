package pairmatching.service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.model.MatchInfo;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PairHistory)) return false;
        PairHistory other = (PairHistory) obj;
        return (Objects.equals(this.course, other.course) && (Objects.equals(this.level, other.level))
        && (Objects.equals(this.mission, other.mission)));
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, level, mission);
    }

    public boolean isSameCondition(MatchInfo matchInfo){
        return this.course == matchInfo.getCourse() && this.level == matchInfo.getLevel()
                && this.mission == matchInfo.getMission();
    }

    public boolean equalLevel(Level level){
        return this.level.equals(level);
    }

    public List<Pair> getPairs() {
        return pairs;
    }
}
