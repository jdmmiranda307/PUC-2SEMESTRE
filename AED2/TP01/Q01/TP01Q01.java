class TP01Q01 {
    //METHOD THAT RECIEVES A STRING AS PARAM, VERIFY IF THIS STRING IS A PALINDROME 
    // ITERING BY THE FIRST POSITION AND THE LAST AND INCRESING AND DRECRISING THE POSITIONS TO VERIFY THE WORD.
    //AND RETURNS 'SIM'  IF IT IS, AND 'NAO' IF IT'S NOT
    public static String palindromo(String p){
        String palindromo = "SIM";
        int metade = p.length()/2;
        for(int i = 0; i < metade; i++){
            int j = p.length()-1 - i;
            if(p.charAt(i) != p.charAt(j)){
                palindromo = "NAO";
            }
        }
        return palindromo;
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
                MyIO.println(palindromo(in[i]));
        }
    }
}
