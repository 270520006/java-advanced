@FunctionalInterface
public interface ZSP<A,B,C,D> {
    D apply(A a,B b,C c);
}
