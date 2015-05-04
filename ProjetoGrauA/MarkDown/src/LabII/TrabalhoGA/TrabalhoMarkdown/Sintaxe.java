package LabII.TrabalhoGA.TrabalhoMarkdown;

/**
 *
 * @author Gustavo
 */
public abstract class Sintaxe {
    private String content;
    
    public Sintaxe(String content){
        this.content = content;
     }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }    
    
}
