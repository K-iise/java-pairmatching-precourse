package pairmatching.model;

public enum Mission {
    CAR_RACE("자동차경주", Level.LEVEL1),
    LOTTO("로또", Level.LEVEL1),
    BASEBALL_NUMBER("숫자야구게임", Level.LEVEL1),
    CART("장바구니", Level.LEVEL2),
    PAY("결제", Level.LEVEL2),
    SUBWAY("지하철노선도", Level.LEVEL2),
    PERFORMANCE("성능개선",Level.LEVEL4),
    DEPLOYMENT("배포", Level.LEVEL4);

    private String name;
    private Level level;

    Mission(String name, Level level) {
        this.name = name;
        this.level = level;
    }

    private static Mission fromMission(String name){
        for (Mission mission : Mission.values()){
            if (mission.name.equals(name)){
                return mission;
            }
        }

        throw new IllegalArgumentException("[ERROR] 유효하지 않은 미션입니다.");
    }

    public static Mission getMissionByLevel(Level level, String missionName) {
        Mission mission = fromMission(missionName);
        if (mission.level != level) {
            throw new IllegalArgumentException("[ERROR] 해당 레벨에 존재하지 않는 미션입니다.");
        }
        return mission;
    }
}
