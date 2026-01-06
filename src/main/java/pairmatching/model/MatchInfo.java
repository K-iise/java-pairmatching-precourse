package pairmatching.model;

public class MatchInfo {
    private Course course;
    private Level level;
    private Mission mission;

    private MatchInfo(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public static MatchInfo from(String input) {
        String[] parts = input.split(",");

        Course course = Course.fromCourse(parts[0].trim());
        Level level = Level.fromLevel(parts[1].trim());
        Mission mission = Mission.getMissionByLevel(level, parts[2].trim());

        return new MatchInfo(course, level, mission);
    }
}
