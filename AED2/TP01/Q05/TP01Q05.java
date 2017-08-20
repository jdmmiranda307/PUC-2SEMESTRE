import java.util.Random;
class TP01Q05 {
    public static void main(String[] args){
        MyIO.setCharset("ISO-8859-1");
        String[] in  = new String[1000];
        String line;
        int numIn = 0;
        do{     
             in[numIn] = MyIO.readLine(); 
        } while(in[numIn++].equals("FIM") == false);
        numIn--;
        for(int i = 0; i < numIn; i++){
            boolean vogais = soVogais(in[i]);
            if(vogais)
                MyIO.print("SIM ");
            else
                 MyIO.print("NAO ");
        
            boolean consoantes = soConsoantes(in[i]);
            if(consoantes)
                MyIO.print("SIM ");
            else
                 MyIO.print("NAO ");

            boolean eInteiro = eInteiro(in[i]);
            if(eInteiro)
                MyIO.print("SIM ");
            else
                 MyIO.print("NAO ");

            boolean eDecimal = eDecimal(in[i]);
            if(eDecimal)
                MyIO.print("SIM");
            else
                 MyIO.print("NAO");

            MyIO.print("\n");
        }
    }

    //METHOD THAT RECIEVES A STRING AS PARAM, AND VERIFY IF IN THIS STRING EXISTS ONLY VOWELS
    // IT RETURNS TRUE IF ITS ONLY VOWELS AND FALSE IF IT'S NOT
    public static boolean soVogais(String p){
        boolean soVogais = true;
        int i = 0;
        do{
            if(p.charAt(i) != 'a' && p.charAt(i) != 'i' && p.charAt(i) != 'u' && p.charAt(i) != 'e' && p.charAt(i) != 'o')
                soVogais = false;
            i++;
        }while(soVogais == true && p.length() > i+1);
        
        return soVogais;
    }


    //METHOD THAT RECIEVES A STRING AS PARAM, AND VERIFY IF IN THIS STRING EXISTS ONLY CONSONANTS
    // IT RETURNS TRUE IF ITS ONLY CONSONANTS AND FALSE IF IT'S NOT
    public static boolean soConsoantes(String p){
        boolean soConsoantes = true;
        int i = 0;
        do{
            if(p.charAt(i) == 'a' || p.charAt(i) == 'i' || p.charAt(i) == 'u' || p.charAt(i) == 'e' || p.charAt(i) == 'o')
                soConsoantes = false;
            if(p.charAt(i) == '0' && p.charAt(i) == '1' || p.charAt(i) == '2' || p.charAt(i) == '3' || p.charAt(i) == '4' || p.charAt(i) == '5' || p.charAt(i) == '6' || p.charAt(i) == '7' || p.charAt(i) == '8' || p.charAt(i) == '9')
                soConsoantes = false;
            i++;
        }while(soConsoantes == true && p.length() > i);
        
        return soConsoantes;
    }

    //METHOD THAT RECIEVES A STRING AS PARAM, AND VERIFY IF ITS A INTEGER NUMBER
    // IT RETURNS TRUE IF ITS INTEGER AND FALSE IF IT'S NOT
    public static boolean eInteiro(String p){
        boolean eInteiro = true;
        int i = 0;
        do{
            if(p.charAt(i) != '0' && p.charAt(i) != '1' && p.charAt(i) != '2' && p.charAt(i) != '3' && p.charAt(i) != '4' && p.charAt(i) != '5' && p.charAt(i) != '6' && p.charAt(i) != '7' && p.charAt(i) != '8' && p.charAt(i) != '9')
                eInteiro = false;
            i++;
        }while(eInteiro == true && p.length() > i);
        
        return eInteiro;
    }

    //METHOD THAT RECIEVES A STRING AS PARAM, AND VERIFY IF ITS A DECIMAL NUMBER
    // IT RETURNS TRUE IF ITS DECIMAL AND FALSE IF IT'S NOT
    public static boolean eDecimal(String p){
        boolean eDecimal = true;
        int i = 0;
        int pontuacao = 0;
        do{
            if(p.charAt(i) != '0' && p.charAt(i) != '1' && p.charAt(i) != '2' && p.charAt(i) != '3' && p.charAt(i) != '4' && p.charAt(i) != '5' && p.charAt(i) != '6' && p.charAt(i) != '7' && p.charAt(i) != '8' && p.charAt(i) != '9' && p.charAt(i) != '.' && p.charAt(i) != ',')
                eDecimal = false;
            if(p.charAt(i) == ',' || p.charAt(i) == '.')
                pontuacao++;
            i++;
        }while(eDecimal == true && p.length() > i);
        
        if(pontuacao > 1)
            eDecimal = false;
        return eDecimal;
    }
}
    