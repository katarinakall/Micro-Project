import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

import java.nio.charset.Charset;

public class MonsterGame {
    public static void main(String[] args) throws InterruptedException {
        Terminal terminal = TerminalFacade.createTerminal(System.in,
                System.out, Charset.forName("UTF8"));
        terminal.enterPrivateMode();

        Player hero = new Player(5,5);
        terminal.moveCursor(hero.x, hero.y);
        terminal.putCharacter('\u263A');

        Enemy alien = new Enemy(1,1);
        terminal.moveCursor(alien.x, alien.y);
        terminal.putCharacter('\u2639');

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
                    break;
                case ArrowUp:
                    hero.y = hero.y -1;
                    break;
                case ArrowLeft:
                    hero.x = hero.x -1;
                    break;
                case ArrowRight:
                    hero.x = hero.x +1;
                    break;

            }
            System.out.println(key.getCharacter() + " " + key.getKind());

            terminal.clearScreen();

            terminal.moveCursor(hero.x, hero.y);
            terminal.putCharacter('\u263A');


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
