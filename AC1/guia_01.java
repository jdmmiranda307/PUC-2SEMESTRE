class guia_01{
    public static String dec2bin(int x){
        return Integer.toBinaryString(x);
    }
    public static int bin2dec(String x){
        return Integer.parseInt(x, 2);
    }
    public static String dec2base(int x, int base){
        String bin = dec2bin(x)  + "";       
        return Integer.parseInt(bin, base);
    }

    public static void main(String[] args){
        System.out.print(dec2bin(16));
        System.out.println(bin2dec("10000"));
        System.out.println(dec2base(16, 4));
    }
}