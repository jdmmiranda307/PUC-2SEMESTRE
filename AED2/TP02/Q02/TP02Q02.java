class TP02Q02 {
  public static String caesarCipher(String s){
    String caesarCipher = "";
    return caesarCipher(s, 0, caesarCipher);
  }
  //METHOD THAT RECEIVES AS PARAMETERS A MAIN STRING, A INDEX TO TAKE THE CHAR POSITIONS IN THE STRING AND
  // CIPHER THEM, ADDING 3 POSITIONS IS ASCII TABLE TO EACH CHAR. METHOD ALSO RECIEVES A AUXILIAR STRING CALLED P
  // TO MAINTAIN THE CIPHERED STRING.
  // IT RETURNS THE CIPHERED STRING AFTER CIPHER CHARACTER PER CHARACTER RECURSIVLY
  public static String caesarCipher(String s, int i, String p){
    String caesarCipher = "";
    if(i > s.length()-1){
      caesarCipher = p;
    }
    else{ 
      String cipher = "";
      int aux = s.charAt(i);
      aux+=3;
      cipher = p + Character.toString((char) aux);
      caesarCipher = caesarCipher(s, i+=1, cipher);
    }
    return caesarCipher;
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
      MyIO.println(caesarCipher(in[i]));
    } 
  }
}