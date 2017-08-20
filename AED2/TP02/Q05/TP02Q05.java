import java.util.Random;
class TP02Q05 {
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

    //METHOD THAT RECIEVES A STRING AS PARAM, AND CALLS THE RECURSIVE METHOD TO CHECK IF THERE IS ONLY VOWELS IN THE STRING
    // IT RETURNS TRUE IF ITS ONLY VOWELS AND FALSE IF IT'S NOT
    public static boolean soVogais(String p){
        return soVogais(p, 0);
    }
    
    //RECURSIVE METHOD THAT RECIEVES AN STRING p AND AN INDICE i AND VERIFY IF IN THE STRING, IN THE CURRENT POSITION
    // i, THERE IS A VOWEL. IF ITS NOT IT RETURNS FALSE, IF IT IS, THE METHOD CONTINUE UNTIL IT REACH THE END OF THE STRING, RETURNING TRUE.
    public static boolean soVogais(String p, int i){
        boolean soVogais = true;
        if(i == p.length()){
            soVogais = true;
        }
        else{
            if(p.charAt(i) != 'a' && p.charAt(i) != 'i' && p.charAt(i) != 'u' && p.charAt(i) != 'e' && p.charAt(i) != 'o')
                soVogais = false;
            if(soVogais)
                soVogais = soVogais(p, i+=1);
        }        
        return soVogais;
    }


    //METHOD THAT RECIEVES A STRING AS PARAM, AND CALLS THE RECURSIVE METHOD TO CHECK IF THERE IS ONLY CONSONANTS IN THE STRING
    // IT RETURNS TRUE IF ITS ONLY CONSONANTS AND FALSE IF IT'S NOT
    public static boolean soConsoantes(String p){
        return soConsoantes(p, 0);
    }

    //RECURSIVE METHOD THAT RECIEVES AN STRING p AND AN INDICE i AND VERIFY IF IN THE STRING, IN THE CURRENT POSITION
    // i, THERE IS A CONSONANT. IF ITS NOT IT RETURNS FALSE, IF IT IS, THE METHOD CONTINUE UNTIL IT REACH THE END OF THE STRING, RETURNING TRUE.
    public static boolean soConsoantes(String p, int i){
        boolean soConsoantes = true;
        if(i == p.length()){
            soConsoantes = true;
        }
        else{
            if(p.charAt(i) == 'a' || p.charAt(i) == 'i' || p.charAt(i) == 'u' || p.charAt(i) == 'e' || p.charAt(i) == 'o')
                soConsoantes = false;
            if(p.charAt(i) == '0' && p.charAt(i) == '1' || p.charAt(i) == '2' || p.charAt(i) == '3' || p.charAt(i) == '4' || p.charAt(i) == '5' || p.charAt(i) == '6' || p.charAt(i) == '7' || p.charAt(i) == '8' || p.charAt(i) == '9')
                soConsoantes = false;
            if(soConsoantes)
                soConsoantes = soConsoantes(p, i+=1);
        }        
        return soConsoantes;
    }

    //METHOD THAT RECIEVES A STRING AS PARAM, AND CALLS THE RECURSIVE METHOD TO CHECK IF ITS AN INTEGER
    // IT RETURNS TRUE IF ITS A INTEGER AND FALSE IF IT'S NOT
    public static boolean eInteiro(String p){
        return eInteiro(p, 0);
    }

    //RECURSIVE METHOD THAT RECIEVES AN STRING p AND AN INDICE i AND VERIFY IF IN THE STRING, IN THE CURRENT POSITION
    // i, THERE IS A INTEGER NUMBER. IF ITS NOT IT RETURNS FALSE, IF IT IS, THE METHOD CONTINUE UNTIL IT REACH THE END OF THE STRING, RETURNING TRUE.
    public static boolean eInteiro(String p, int i){
        boolean eInteiro = true;
        if(i == p.length()){
            eInteiro = true;
        }
        else{
             if(p.charAt(i) != '0' && p.charAt(i) != '1' && p.charAt(i) != '2' && p.charAt(i) != '3' && p.charAt(i) != '4' && p.charAt(i) != '5' && p.charAt(i) != '6' && p.charAt(i) != '7' && p.charAt(i) != '8' && p.charAt(i) != '9')
                eInteiro = false;
            if(eInteiro)
                eInteiro = eInteiro(p, i+=1);
        }        
        return eInteiro;
    }

    //METHOD THAT RECIEVES A STRING AS PARAM, AND CALLS THE RECURSIVE METHOD TO CHECK IF ITS AN DECIMAL
    // IT RETURNS TRUE IF ITS A INTEGER AND FALSE IF IT'S NOT
    public static boolean eDecimal(String p){
        return eDecimal(p, 0, 0);
    }

    //RECURSIVE METHOD THAT RECIEVES AN STRING p, AN INDICE i, AND A COUNTER pontuacao AND VERIFY IF IN THE STRING, IN THE CURRENT POSITION
    // i, THERE IS A NUMBER OR IF IT IS AN DOT OR COMMA. IF ITS NOT IT RETURNS FALSE, IF IT IS A COMMA OR A DOT IT INCREASE THE pontuacao COUNTER
    // AND THEN THE METHOD CONTINUES IT RECURSIVE CALLS UNTIL THE END OF THE STRING
    // RETURNING TRUE IF THE pontuacao IS SMALLER OR EQUAL THAN 1 AND ALL OF THE ELEMENTS WERE NUMBERS.
    public static boolean eDecimal(String p, int i, int pontuacao){
        boolean eDecimal = true;
        if(i == p.length()){
            eDecimal = true;
        }
        else{
            if(p.charAt(i) != '0' && p.charAt(i) != '1' && p.charAt(i) != '2' && p.charAt(i) != '3' && p.charAt(i) != '4' && p.charAt(i) != '5' && p.charAt(i) != '6' && p.charAt(i) != '7' && p.charAt(i) != '8' && p.charAt(i) != '9' && p.charAt(i) != '.' && p.charAt(i) != ',')
                eDecimal = false;
            if(p.charAt(i) == ',' || p.charAt(i) == '.'){
                pontuacao += 1;
                if(pontuacao > 1)
                    eDecimal = false;
            }
            if(eDecimal)
                eDecimal = eDecimal(p, i+=1, pontuacao);
        }        
        return eDecimal;
    }
}
    