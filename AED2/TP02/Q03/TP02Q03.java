import java.util.Random;
class TP02Q03 {
    public static void main(String[] args){
        MyIO.setCharset("ISO-8859-1");
        String[] in  = new String[1000];
        String line;
        RandomChange random = new RandomChange();
        int numIn = 0;
        do{     
             in[numIn] = MyIO.readLine(); 
        } while(in[numIn++].equals("FIM") == false);
        numIn--;
        for(int i = 0; i < numIn; i++){
            MyIO.println(random.randomChanges(in[i]));
        }
    }
}
class RandomChange{
    Random random = new Random(4);
    //METHOD THAT RECIEVES AN STRING, CREATE 2 CHARS THAT REPRESENTS A CHARACTER THAT WILL BE REPLACED IN THE STRING
    //AND A SECOND CHAR THAT REPRESENTS THE NEW CHARACTER THAT WILL REPLACE THE SELECTED ONE
    //THIS METHOD RETURNS THE CALL OF THE RECURSIVY METHOD
    public String randomChanges(String p){
        char letraBase = (char)('a' + (Math.abs(random.nextInt()) % 26));
        char novaLetra = (char)('a' + (Math.abs(random.nextInt()) % 26));
        return randomChanges(p, 0, letraBase, novaLetra, "");
    }
    //METHOD THAT RECIEVES AS ṔARAMETER A STRING THAT REPRESENT THE FULL WORD THAT IS BEING VERIFIED AND CHANGED
    //AN INT INDICE TO CHECK EACH CHAR RECURSIVLY
    //AN CHAR THAT REPRESENTS THE CHARACTER THAT WILL BE CHANGED
    //ANOTHER CHAR THAT IS THE ONE THAT WILL REPLACE THE CHANGED
    //AND FINNALY IT TAKES AN STRING THAT IS BUILT DURING THE STACK OF THE METHOD WITH THE WORD REWRITED
    //RETURN STRING WITH THE NEW WORD BUILT
    public String randomChanges(String p, int i, char lB, char lN, String aux){
        String randomChanges = "";
        if(i == p.length())
            randomChanges = aux;
        else{
            if(p.charAt(i) == lB)
                aux = aux + lN;
            else
                aux = aux + p.charAt(i);
            randomChanges = randomChanges(p, i+=1, lB, lN, aux);
        }
        return randomChanges;
    }
}