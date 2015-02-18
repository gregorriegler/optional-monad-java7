public class Optional<T> {

    private static final Optional<?> EMPTY = new Optional<>(null);
    private final T value;

    public Optional(T value) {
        this.value = value;
    }

    public <U> Optional<U> map(Function<T, U> f) {
        return value == null ? (Optional<U>) EMPTY : new Optional<>(f.apply(value));
    }

    public <U> Optional<U> flatMap(Function<T, Optional<U>> f) {
        return value == null ? (Optional<U>) EMPTY : f.apply(value);
    }

    public T orElse(T value) {
        if(this.value == null) return value;
        return this.value;
    }
}
