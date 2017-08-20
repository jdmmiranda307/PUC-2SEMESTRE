class TP02Q00 {
   public static boolean isMaiuscula (char c){
      return (c >= 'A' && c <= 'Z');
   }
 
   public static int contarLetrasMaiusculas(String s){
      return contarLetrasMaiusculas(s, s.length()-1);
   }
    //METHOD THAT RECEIVES A STRING AS A PARAMETER AND A INDEX TO RECURSIVELY ITERATE THROUGH THE STRING
    // IT COUNTS EACH UPPERCASE WORD AND RETURN THE NUMBER OF THEM FOUND.
   public static int contarLetrasMaiusculas(String s, int i){
        int resp = 0;
        if(i < 0){
            resp = 0;
        }
        else{
            if(isMaiuscula(s.charAt(i)) == true)
                resp ++;
            i = i-1;
            resp += contarLetrasMaiusculas(s, i);
        } 
        return resp;
    }
 
   public static void main (String[] args){
        MyIO.setCharset("ISO-8859-1");
        String[] in  = new String[1000];
        String line;
        int numIn = 0;
        do{     
             in[numIn] = MyIO.readLine(); 
        } while(in[numIn++].equals("FIM") == false);
        numIn--;
        for(int i = 0; i < numIn; i++){
                MyIO.println(contarLetrasMaiusculas(in[i]));
        }
   }
}