package utils;

public class DocumentoUtil {

    public static String firstWord(String texto){
         int i = texto.indexOf(' ');
         return texto.substring(0,i);
    }

    public static String removerPontuacao(String texto){
        return texto.replace(",","");
    }

}
