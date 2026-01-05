package pairmatching.model;

public enum Mission {
    CAR_RACE("자동차경주"),
    LOTTO("로또"),
    BASEBALL_NUMBER("숫자야구게임"),
    CART("장바구니"),
    PAY("결제"),
    SUBWAY("지하철노선도"),
    PERFORMANCE("성능개선"),
    DEPLOYMENT("배포");

    String name;

    Mission(String name) {
        this.name = name;
    }
}
