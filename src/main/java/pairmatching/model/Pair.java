package pairmatching.model;

import java.util.Objects;

public class Pair {
    private String crew1;
    private String crew2;

    public Pair(String crew1, String crew2) {
        if (crew1.compareTo(crew2) <= 0) {
            this.crew1 = crew1;
            this.crew2 = crew2;
        }
        this.crew1 = crew2;
        this.crew2 = crew1;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Pair)) return false;

        Pair other = (Pair) obj;
        return (Objects.equals(crew1, other.crew1) && (Objects.equals(crew2, other.crew2)))
                || (Objects.equals(crew1, other.crew2) && (Objects.equals(crew2, other.crew1)));
    }

    @Override
    public int hashCode() {
        return Objects.hash(crew1) + Objects.hash(crew2);
    }

    public String getCrew1() {
        return crew1;
    }

    public String getCrew2() {
        return crew2;
    }
}
