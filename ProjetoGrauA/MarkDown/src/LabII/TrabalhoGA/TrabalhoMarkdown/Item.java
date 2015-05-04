package LabII.TrabalhoGA.TrabalhoMarkdown;

/**
 *
 * @author Gustavo Lazarotto Schroeder
 */
public class Item extends Sintaxe {

    private int level;
    private boolean breakline;

    public Item(int level, String content) {
        super(content);
        this.level = level;
        this.breakline = true;
    }
     
    
    public int getLevel() {
        return level;
    }

    public boolean isBreakline() {
        return breakline;
    }

    @Override
    public String toString() {
        return "[Item]Level" + level + ", Content: " + super.getContent() + "breakline" + breakline;
    }

}
