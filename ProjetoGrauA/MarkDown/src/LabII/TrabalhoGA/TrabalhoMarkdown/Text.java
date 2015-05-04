package LabII.TrabalhoGA.TrabalhoMarkdown;

/**
 *
 * @author Gustavo Lazarotto Schroeder
 */
public class Text extends Sintaxe {
    /*representa um elemento de texto que pode conter ou não formatação 
     (atributo style) e pode terminar ou não com quebra de linha (breakLine). 
     Os estilos suportados no trabalho são: *(I)tálic*, **(B)old** ou _(U)nderline_ */

    private String content;
    private boolean breakLine;

    public Text(String content, boolean breakLine) {
        super(content);
        this.breakLine = breakLine;
    }

    @Override
    public String toString() {
        if (breakLine == true) {
            return "Text: {Content = " + super.getContent() + " -Breakline: " + breakLine + "/n";
        }
        return "Text: {Content = " + super.getContent() + " -Breakline: " + breakLine;
    }

}
