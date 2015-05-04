package LabII.TrabalhoGA.TrabalhoMarkdown;

/**
 *
 * @author Gustavo Lazarotto Schroeder
 */
public class Title extends Sintaxe {

    private int nível;

    public Title(String título, int nível) {
        super(título);
        this.nível = nível;
    }

    public int getNível() {
        return nível;
    }

    @Override
    public String toString() {
        return "[TITLE] Level " + nível + "  Título: " + super.getContent();
    }
    /* public void exibeDados(){
     System.out.println("Level: " + nível + "Título: " + content);
     }
     */

}
