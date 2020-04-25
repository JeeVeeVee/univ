package DynamischProgrameren.SomVanGetallen;

import java.util.Collection;

public interface Som {
    /**
     * Bereken het aantal mogelijkheden om {@code n} te schrijven als som van getallen uit {@code getallen}.
     */
    int mogelijkheden(int n, Collection<Integer> getallen);
}