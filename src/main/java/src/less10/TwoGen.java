package src.less10;

public class TwoGen<T, V> {
    private T obT;
    private V obV;

    public TwoGen(T obT, V obV) {
        this.obT = obT;
        this.obV = obV;
    }

    public T getObT() {
        return obT;
    }

    public V getObV() {
        return obV;
    }

    public void showTypes() {
        System.out.println("T: " + obT.getClass().getName());
        System.out.println("V: " + obV.getClass().getName());
    }
}

class TestTwoGen {
    public static void main(String[] args) {
        TwoGen<Integer, String> twoGen = new TwoGen<>(88, "asdsda");
        twoGen.showTypes();
    }
}
