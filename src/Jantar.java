public class Jantar {
    public static void main(String[] args) {
        Mesa mesa = new Mesa();
        Filosofo f0 = new Filosofo(0, mesa);
        Filosofo f1 = new Filosofo(1, mesa);
        Filosofo f2 = new Filosofo(2, mesa);
        Filosofo f3 = new Filosofo(3, mesa);
        Filosofo f4 = new Filosofo(4, mesa);

        new Thread(f0).start();
        new Thread(f1).start();
        new Thread(f2).start();
        new Thread(f3).start();
        new Thread(f4).start();
    }
}