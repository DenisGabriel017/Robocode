package calango; // Certifique-se de que seu pacote seja "calango"

import robocode.*;

public class CalangoBot extends Robot {
    private int power = 1; // Potência inicial do tiro
    
    @Override
    public void run() {
        // Loop infinito para mover o robô continuamente
        while (true) {
            // Move o robô para frente
            ahead(150);
            
            // Gira o robô 90 graus
            turnRight(80);
            
            // Atira com a potência atual
            fire(power);
            
            // Alterna entre as potências de tiro de 1 a 3
            power = (power % 3) + 1;
            
            // Verifica se o jogo foi vencido
            if (getOthers() == 0) {
                System.out.println("Ganhei a partida!");
                break; // Sai do loop se ganhou
            }
        }
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent event) {
        // Quando um inimigo é escaneado, atire nele com a potência atual
        fire(power);
    }
}