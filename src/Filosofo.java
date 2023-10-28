import java.util.Random;

public class Filosofo implements Runnable {

    private int posicao;
    private boolean bloqueado;
    private Mesa mesa;
    private Random random = new Random();

    public Filosofo(int posicao, Mesa mesa) {
        this.posicao = posicao;
        this.mesa = mesa;
        this.bloqueado = false;
    }

    public int getPosicao() {
        return posicao;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void bloquear() {
        this.bloqueado = true;
    }

    public void desbloquear() {
        this.bloqueado = false;
    }

    @Override
    public void run() {
        try {
           while (true){
               this.pensar();
               this.mesa.pegarGarfos(this);
               this.comer();
               this.mesa.devolverGarfos(this);
           }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filósofo " + posicao + " pensando");
        Thread.sleep(random.nextLong(4001) + 1000);
    }

    private void comer() throws InterruptedException {
        if(bloqueado) {
            System.out.println("Filósofo " + posicao + " bloqueado! Não é possível comer agora.");
            return;
        }
        System.out.println("Filósofo " + posicao + " comendo");
        Thread.sleep(random.nextLong(4001) + 1000);
    }
}
