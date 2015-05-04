package LabII.TrabalhoGA.TrabalhoMarkdown;

/**
 *
 * @author Gustavo Lazarotto Schroeder
 */
public class Link extends Sintaxe {

    private boolean breakline;

    public Link(String referencia) {
        super(referencia);
        breakline = false;
    }

    public boolean isBreakline() {
        return breakline;
    }

    @Override
    public String toString() {
        return "Pagina da Web (Link): " + super.getContent() + "Breakline: " + isBreakline();
    }
    /*
     public void exibeDados(){
     System.out.print("Content: " + "Link: " + content);
     }
     */
}
