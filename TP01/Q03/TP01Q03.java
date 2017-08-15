import java.util.Random;
class TP01Q03 {
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
            random.randomChanges(in[i]);
        }
    }
}
class RandomChange{
    Random random = new Random(4);
    //METH OD THAT RECIEVES A STRING AS PARAM, AND CHANGES 1 CHARACTER TO ANOTHER RANDOMIZED
    // IT RANDOMIZE 2 CHARACTERS, THE FIRST WILL BE THE ONE IN THE STRING THAT WILL BE REPLACED BY THE SECOND ONE
    // PRINTS EACH CHARACTER FROM THE STRING AND WHEN IT FINDS THE ONE THAT WILL BE REPLACED, IT PRINTS THE NEW ONE
    public void randomChanges(String p){
        char letraBase = (char)('a' + (Math.abs(random.nextInt()) % 26));
        char novaLetra = (char)('a' + (Math.abs(random.nextInt()) % 26));
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) == letraBase)
                MyIO.print(novaLetra);
            else
                MyIO.print(p.charAt(i));
        }
        MyIO.print('\n');
    }
}