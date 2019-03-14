import java.util.function.Predicate;

@FunctionalInterface
public interface Policity {
    void setPolicity(Predicate<Sweets> predicate);
}
