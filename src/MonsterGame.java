import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

import java.nio.charset.Charset;
import java.util.ArrayList;

public class MonsterGame {
    public static void main(String[] args) throws InterruptedException {

        Terminal terminal = TerminalFacade.createTerminal(System.in,
                System.out, Charset.forName("UTF8"));
        terminal.enterPrivateMode();

        Player hero = new Player(5,5);
        terminal.moveCursor(hero.x, hero.y);
        terminal.putCharacter('\u263A');

        Enemy alien = new Enemy(11,16);
        terminal.moveCursor(alien.x, alien.y);
        terminal.putCharacter('\u26C4');

        Enemy ghost = new Enemy(17,25);
        terminal.moveCursor(ghost.x, ghost.y);
        terminal.putCharacter('\u26C4');

        Enemy monster = new Enemy(3,29);
        terminal.moveCursor(monster.x, monster.y);
        terminal.putCharacter('\u26C4');

        Enemy janne = new Enemy(35,27);
        terminal.moveCursor(janne.x, janne.y);
        terminal.putCharacter('\u26C4');


        while (true) {
//Wait for a key to be pressed
            Key key;
            do {
                Thread.sleep(5);
                key = terminal.readInput();
            }
            while (key == null);


            switch (key.getKind()) {
                case ArrowDown:
                    hero.y = hero.y +1;
                    if (hero.y > 29)
                        hero.y = 29;
                    break;
                case ArrowUp:
                    hero.y = hero.y -1;
                    if (hero.y < 0)
                        hero.y = 0;
                    break;
                case ArrowLeft:
                    hero.x = hero.x -1;
                    if (hero.x < 0)
                    hero.x = 0;
                    break;
                case ArrowRight:
                    hero.x = hero.x +1;
                    if (hero.x > 98)
                        hero.x = 98;
                    break;

            }
            System.out.println(key.getCharacter() + " " + key.getKind());

            terminal.clearScreen();

            terminal.moveCursor(hero.x, hero.y);
            terminal.putCharacter('\u263A');

            terminal.moveCursor(alien.x, alien.y);
            terminal.putCharacter('\u26C4');

            terminal.moveCursor(ghost.x, ghost.y);
            terminal.putCharacter('\u26C4');

            terminal.moveCursor(monster.x, monster.y);
            terminal.putCharacter('\u26C4');

            terminal.moveCursor(janne.x, janne.y);
            terminal.putCharacter('\u26C4');




        }
    }
    private static void printText(int x, int y, String message, Terminal
            terminal) {
        for (int i=0;i<message.length();i++)
        {
            terminal.moveCursor(x, y);
            terminal.putCharacter(message.charAt(i));
            x=x+1;
        }
    }


}
