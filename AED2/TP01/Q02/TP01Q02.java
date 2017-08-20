class TP01Q02 {
    //METHOD THAT RECIEVES A STRING AS PARAM, AND PARSE TO CAESAR CIPHER
    // CHANGINH EACH WORD TO 3 POSITIONS AHEAD IN ASCII TABLE.
    //FINALLY IT RETURNS THE CIPHERED WORD
    public static String caesar(String p){
    	String cifred = "";
        for(int i = 0; i < p.length(); i++){
            int aux = p.charAt(i);
            aux+=3;
            cifred = cifred + Character.toString((char) aux);
        }
        return cifred;
    }
        
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
                MyIO.println(caesar(in[i]));
        }
    }
}
