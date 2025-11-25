import java.io.Console;
import java.util.*;

class Card {
    private String symbol;
    private boolean matched;

    public Card(String symbol) {
        this.symbol = symbol;
        this.matched = false;
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isMatched() {
        return matched;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    @Override
    public String toString() {
        return matched ? symbol : "??";
    }
}

abstract class Event {
    public abstract void trigger();
}

class LoveEvent extends Event {
    @Override
    public void trigger() {
        System.out.println("\n A gentle light spreads across the town...");
        Utils.println("Families embrace once more as LOVE 🤍 warms their hearts.\n");
    }
}

class PeaceEvent extends Event {
    @Override
    public void trigger() {
        System.out.println("\n The howling winds grow quiet...");
        Utils.println("PEACE 🌿 returns to Everpine. Snowflakes fall softly under the calm sky.\n");
    }
}

class WarmthEvent extends Event {
    @Override
    public void trigger() {
        System.out.println("Hearths glow through the night as the chill retreats beyond the hills.");
        Utils.println("\n The fires of WARMTH ☕ return!\n");
    }
}

class JoyEvent extends Event {
    @Override
    public void trigger() {
        System.out.println("\n Bells ring! Laughter echoes through the streets!");
        Utils.println("JOY 🎶 fills the air as carols awaken the long-silent town square.\n");
    }
}

class TreeGiftChaosEvent extends Event {
    @Override
    public void trigger() {
        Utils.println("The Everpine Tree suddenly sneezes tinsel across Market Square!");
    }
}

class TreeSnowmanChaosEvent extends Event {
    @Override
    public void trigger() {
        Utils.println("A Snowman hugs the tree too hard and dumps snow all over the town!");
    }
}

class TreeBellChaosEvent extends Event {
    @Override
    public void trigger() {
        Utils.println("The bells vibrate the Everpine tree so strongly that pine needles rain everywhere!");
    }
}

class GiftTreeChaosEvent extends Event {
    @Override
    public void trigger() {
        Utils.println("A wandering gift explodes into glitter beneath the town tree!");
    }
}

class GiftSnowmanChaosEvent extends Event {
    @Override
    public void trigger() {
        Utils.println("A Snowman throws a gift like a snowball, knocking over fruit carts!");
    }
}

class GiftBellChaosEvent extends Event {
    @Override
    public void trigger() {
        Utils.println("A bell gets trapped inside a gift box and rings nonstop across Everpine!");
    }
}

class SnowmanTreeChaosEvent extends Event {
    @Override
    public void trigger() {
        Utils.println("A Snowman melts near the warm tree, flooding the mayor's paperwork!");
    }
}

class SnowmanGiftChaosEvent extends Event {
    @Override
    public void trigger() {
        Utils.println("The Snowman finds coal in a gift and freezes the entire fountain!");
    }
}

class SnowmanBellChaosEvent extends Event {
    @Override
    public void trigger() {
        Utils.println("The Snowman rings a bell so hard his hat launches into a chimney!");
    }
}

class BellTreeChaosEvent extends Event {
    @Override
    public void trigger() {
        Utils.println("A runaway bell bounces down Everpine Hill, knocking over market stalls!");
    }
}

class BellGiftChaosEvent extends Event {
    @Override
    public void trigger() {
        Utils.println("A bell hides in a gift box and rings wildly, making every dog bark!");
    }
}

class BellSnowmanChaosEvent extends Event {
    @Override
    public void trigger() {
        Utils.println("A bell freezes to a Snowman’s hand—he wanders around chiming uncontrollably!");
    }
}

class MemoryBoard {
    private Card[][] board;
    private int rows = 2, cols = 4;

    public MemoryBoard() {
        String[][] fixedSymbols = {
                {"🤍", "🌿", "☕", "🎶"},
                {"☕", "🎶", "🌿", "🤍"}
        };
        board = new Card[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                board[i][j] = new Card(fixedSymbols[i][j]);
    }

    public void display() {
        Utils.println("");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String card = board[i][j].toString();
                System.out.print(card + "  ");
            }
            Utils.println("");
        }
        Utils.println("");
    }

    public boolean flip(int r1, int c1, int r2, int c2) {
        Card a = board[r1][c1];
        Card b = board[r2][c2];

        Utils.println("You revealed " + a.getSymbol() + " and " + b.getSymbol());

        if (a.isMatched() || b.isMatched()) {
            Utils.println("⚠️ One of those cards is already matched.");
            return false;
        }

        if (a.getSymbol().equals(b.getSymbol())) {
            a.setMatched(true);
            b.setMatched(true);
            return true;
        }

        return false;
    }

    public boolean allMatched() {
        for (Card[] row : board)
            for (Card c : row)
                if (!c.isMatched())
                    return false;
        return true;
    }
}

class Utils {
    public static void print(String format, Object... args) {
        String message = String.format(format, args);
        Console console = System.console();
        if (console != null) {
            console.writer().print(message);
            console.writer().flush();
        } else {
            System.out.print(message);
        }
    }

    public static void println(String format, Object... args) {
        print(format, args);
        System.out.println();
    }
}

public class EverpineChristmas {

    private static final Event[] matchEvents = {
            new LoveEvent(),
            new PeaceEvent(),
            new WarmthEvent(),
            new JoyEvent()
    };

    private static final Event[] mismatchEvents = {
            new TreeGiftChaosEvent(),
            new TreeSnowmanChaosEvent(),
            new TreeBellChaosEvent(),
            new GiftTreeChaosEvent(),
            new GiftSnowmanChaosEvent(),
            new GiftBellChaosEvent(),
            new SnowmanTreeChaosEvent(),
            new SnowmanGiftChaosEvent(),
            new SnowmanBellChaosEvent(),
            new BellTreeChaosEvent(),
            new BellGiftChaosEvent(),
            new BellSnowmanChaosEvent()
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MemoryBoard board = new MemoryBoard();
        int joyLevel = 0;

        Utils.println("🎄========================================🎄");
        System.out.println("        THE LOST CHRISTMAS OF EVERPINE");
        Utils.println("🎄========================================🎄");

        Utils.println("""
                In the frozen town of Everpine, the mischievous Frost Sprite has stolen
                the four great spirits of Christmas: Love, Peace, Warmth, and Joy.
                Only by matching the lost pairs can you restore the light of the season...
                """);

        Utils.println("""
                GUIDE:
                • The board has 2 rows (0–1) and 4 columns (0–3).
                • On each turn, select TWO cards to flip.
                • Enter them as FOUR numbers:  r1 c1 r2 c2
                  Example: 0 1 1 3

                 ⚠️ If you type letters, too few numbers, or numbers out of range,
                   the game will warn you instead of crashing.
                """);

        while (!board.allMatched()) {
            board.display();
            int[] coords = getValidCoordinates(sc);
            int r1 = coords[0], c1 = coords[1], r2 = coords[2], c2 = coords[3];

            boolean match = board.flip(r1, c1, r2, c2);
            if (match) {
                board.display();
                if (joyLevel < matchEvents.length) {
                    matchEvents[joyLevel].trigger();
                    joyLevel++;
                }
            } else {
                mismatchEvents[new Random().nextInt(mismatchEvents.length)].trigger();
            }
        }

        ending();
        sc.close();
    }

    private static int[] getValidCoordinates(Scanner sc) {
        while (true) {
            System.out.print("Choose two cards (r1 c1 r2 c2): ");

            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+");

            if (parts.length != 4) {
                Utils.println("⚠️ You must enter EXACTLY four numbers: r1 c1 r2 c2");
                continue;
            }

            try {
                int r1 = Integer.parseInt(parts[0]);
                int c1 = Integer.parseInt(parts[1]);
                int r2 = Integer.parseInt(parts[2]);
                int c2 = Integer.parseInt(parts[3]);

                if (r1 < 0 || r1 > 1 || r2 < 0 || r2 > 1 ||
                    c1 < 0 || c1 > 3 || c2 < 0 || c2 > 3) {
                    Utils.println("⚠️ Coordinates must be within 0–1 for rows and 0–3 for columns.");
                    continue;
                }

                if (r1 == r2 && c1 == c2) {
                    Utils.println("⚠️ You cannot choose the SAME card twice.");
                    continue;
                }

                return new int[]{r1, c1, r2, c2};

            } catch (NumberFormatException e) {
                Utils.println("⚠️ Invalid input! Only numbers are allowed.");
            }
        }
    }

    private static void ending() {
        Utils.println("✨ A radiant light bursts across the sky... ✨");
        System.out.println("The Frost Sprite appears, eyes wide in wonder as Everpine glows once more.\n");

        pause(1000);
        Utils.println("🌠 The bells of the town ring together, echoing through the mountains.");
        pause(1000);
        Utils.println("🎁 Children rush into the streets, laughter melting the last of the snow.");
        pause(1000);
        Utils.println("🎅 Santa's sleigh glimmers above the clouds, drawn by stars and song.");
        pause(1000);

        System.out.println("""
                Frost Sprite: "You’ve shown me... the true heart of Christmas.
                It’s not in spells or snowflakes... but in love, peace, warmth, and joy shared by all."

                The sky shines gold as Everpine awakens.
                The air hums with music, the stars shimmer brighter than ever before.
                """);

        Utils.println("✨🎄 YOU RESTORED THE SPIRIT OF EVERPINE 🎄✨");
        Utils.println("🤍🌿☕🎶  LOVE  |  PEACE  |  WARMTH  |  JOY  🎶☕🌿🤍");
        Utils.println("   🎅 MERRY CHRISTMAS, HERO OF EVERPINE! 🎅");
    }

    private static void pause(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) {}
    }
}
