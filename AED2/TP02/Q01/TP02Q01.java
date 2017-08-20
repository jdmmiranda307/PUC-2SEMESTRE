class TP02Q01 {
  public static boolean ePalindromo(String s){
    return ePalindromo(s, 0, s.length()-1);
  }
    //METHOD THAT RECEIVES AS PARAMETERS A STRING, A INDEX REPRESENTING THE MINOR CHAR
    // TO BE VERIFIED AND A SECOND INDEX TO REPRESENT THE MAJOR CHAR POSITION  BEING VERIFIED
    // IT VERIFY IF THE MINOR CHAR IS EQUAL TO THE MAJOR, AND AFTER THE MINOR INDICE PASS THE HALF
   // OF THE STRING LENGTH, IT RETURN TRUE, ELSE IT RETURN FALSE IF THE CHARS ARE DIFFERENT
  public static boolean ePalindromo(String s, int i, int j){
    boolean ePalindromo = false;
    if(i > s.length()/2){
      if(s.charAt(i) == s.charAt(j))
        ePalindromo = true;
    }
    else{
      if(s.charAt(i) != s.charAt(j))
        ePalindromo = false;
      
      else
        ePalindromo = ePalindromo(s, i+=1, j-=1);
    } 
    return ePalindromo;
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
      boolean resp = (ePalindromo(in[i]));
      if (resp)
        MyIO.println("SIM");
      else
        MyIO.println("NAO");
    } 
  }
}