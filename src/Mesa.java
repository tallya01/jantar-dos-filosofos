import java.util.Arrays;

public class Mesa {
    private EstadosGarfo[] garfos = new EstadosGarfo[5];

    public Mesa() {
        Arrays.fill(this.garfos, EstadosGarfo.DISPONIVEL);
    }

    public synchronized void pegarGarfos(Filosofo filosofo) {
        System.out.println("Filósofo " + filosofo.getPosicao() + " deseja comer");

        int garfoEsquerda = (filosofo.getPosicao() + 4) % 5;
        int garfoDireita = filosofo.getPosicao();

        if(garfos[garfoEsquerda] == EstadosGarfo.EM_USO || garfos[garfoDireita] == EstadosGarfo.EM_USO){
           filosofo.bloquear();
           return;
        }

        garfos[garfoEsquerda] = EstadosGarfo.EM_USO;
        garfos[garfoDireita] = EstadosGarfo.EM_USO;
        filosofo.desbloquear();
    }

    public synchronized void devolverGarfos(Filosofo filosofo) {
        if(filosofo.isBloqueado()) return;

        System.out.println("Filósofo " + filosofo.getPosicao() + " terminou de comer");

        int garfoEsquerda = (filosofo.getPosicao() + 4) % 5;
        int garfoDireita = filosofo.getPosicao();

        garfos[garfoEsquerda] = EstadosGarfo.DISPONIVEL;
        garfos[garfoDireita] = EstadosGarfo.DISPONIVEL;
    }
}
