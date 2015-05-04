package LabII.TrabalhoGA.TrabalhoMarkdown;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JFileChooser;

/**
 *
 * @author Gustavo Lazarotto Schroeder
 */
public class Leitora {

    ArrayList<Sintaxe> markdown = new ArrayList<>();
    ArrayList<Item> lista = new ArrayList<>();

    public void fazLeitura() throws Exception {

        int var = -1;
        int var2 = -1;
        boolean breakline = false;
        String montaFrase = null;
        String normalText = null;
        String normalText2 = null;
        int vari = 0;
        BufferedReader in;
        FileReader fe;
        JFileChooser jfc = new JFileChooser();
        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            fe = new FileReader(jfc.getSelectedFile());
            in = new BufferedReader(fe);
        } else {
            throw new FileDontExistException();
        }
        String line = in.readLine();

        while (line != null) {
            System.out.println(line);
            if ("".equals(line)) {
                line = in.readLine();
                 
            }
            //Verificação de TíTULO
            montaFrase += line.charAt(0);
            if (montaFrase.indexOf("#")== 0){ //testar apenas a primeira pos
                System.out.println("Frase");
                markdown.add(new Title(line, 1));
            }
            else if (montaFrase.indexOf("#") == 1) { // Verifica se é um SubTítulo
                markdown.add(new Title(line, 2));

            }
            //Verificação de PAGINA DA WEB
            if (line.indexOf("[pagina da web]") >= 0) { //Verifica se é um Link
                var = line.indexOf("(");
                var2 = line.indexOf(")");
                String paginaWeb = null;
                for (int j = var; j < var2; j++) {
                    paginaWeb += line.charAt(j);
                }
                markdown.add(new Link(paginaWeb));

            }

            // começa a verificação de TEXT
            if (line.lastIndexOf("") > -1) {
                breakline = true;
            }
            if (line.indexOf("*") >= 0) {
                var = line.indexOf("*");
                var2 = line.lastIndexOf("*");

                if (var != 0) {    //verifica se a formatação começa na primeira palavra
                    for (int i = 0; i < var; i++) {  // se não, gravar em uma variavel
                        normalText += line.charAt(i);
                    }
                    markdown.add(new Text(montaFrase, breakline)); //instacia um TEXT sem formatação
                }

                for (int i = var; i < var2; i++) { // pega a formatação
                    montaFrase += line.charAt(i);
                }
                markdown.add(new Text("Style: [ITALICO] " + montaFrase, breakline)); // Se é Itálico
                if (var2 != line.length()) {   // veifica se há ainda linha após a formatação
                    for (int i = var2; i < line.length(); i++) {
                        normalText2 += line.charAt(i);
                    }
                    markdown.add(new Text(normalText2, breakline));
                }

            }
            if (line.indexOf("**") >= 0) {
                var = line.indexOf("**");
                var2 = line.lastIndexOf("**");

                if (var != 0) {    //verifica se a formatação começa na primeira palavra
                    for (int i = 0; i < var; i++) {  // se não, gravar em uma variavel
                        normalText += line.charAt(i);
                    }
                    markdown.add(new Text(montaFrase, breakline)); //instacia um TEXT sem formatação
                }

                for (int i = var; i < var2; i++) { // pega a formatação
                    montaFrase += line.charAt(i);
                }
                markdown.add(new Text("Style: [BOLD] " + montaFrase, breakline)); // Se é Negrito

                if (var2 != line.length()) {   // veifica se há ainda linha após a formatação
                    for (int i = var2; i < line.length(); i++) {
                        normalText2 += line.charAt(i);
                    }
                    markdown.add(new Text(normalText2, breakline));

                }
                if (line.indexOf("_") >= 0) {
                    var = line.indexOf("_");
                    var2 = line.lastIndexOf("_");

                    if (var != 0) {    //verifica se a formatação começa na primeira palavra
                        for (int i = 0; i < var; i++) {  // se não, gravar em uma variavel
                            normalText += line.charAt(i);
                        }
                        markdown.add(new Text(montaFrase, breakline)); //instacia um TEXT sem formatação
                    }

                    for (int i = var; i < var2; i++) { // pega a formatação
                        montaFrase += line.charAt(i);
                    }
                    markdown.add(new Text("Style: [UNDERLINE] " + line, breakline)); // Se é Sublinha

                    if (var2 != line.length()) {   // veifica se há ainda linha após a formatação
                        for (int i = var2; i < line.length(); i++) {
                            normalText2 += line.charAt(i);
                        }
                        markdown.add(new Text(normalText2, breakline));

                    } else {  // Se não tem formatação
                        markdown.add(new Text(line, breakline));
                    }

                    if (line.indexOf("* ") > 0) {
                        var = line.indexOf("* ");
                        var2 = line.lastIndexOf("*");

                        for (int i = var; i < var2; i++) {
                            montaFrase += line.charAt(i);
                        }
                        lista.add(new Item(1, montaFrase));
                        markdown.add(lista.get(vari++));
                    }

                    for (int i = 0; i < markdown.size(); i++) {
                        System.out.println(markdown.get(i).toString());
                    }

                }
            }
            line = in.readLine();
        }

        /* public void gravaDados() throws IOException {
         int cont = 0;
         FileWriter fr = new FileWriter("D:\\Usuario\\Documents\\ProjetoGrauA\\MarkDown\\src\\LabII\\TrabalhoGA\\TrabalhoMarkdown\\ArquivoProcessado");
         PrintWriter out = new PrintWriter(fr);
         for (int i = 0; i < markdown.size(); i++) {
         if(markdown.get(i).indexOf(lista.get(cont))){
         out.print(lista.get(cont++));
         }
         else
         out.print(markdown.get(i));
         }
         }*/
    }
}
