package pairmatching.model;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course fromCourse(String name){
        for (Course course : Course.values()){
            if (course.name.equals(name)){
                return course;
            }
        }
        throw new IllegalArgumentException("[Error] 유효하지 않은 과정입니다.");
    }
}
