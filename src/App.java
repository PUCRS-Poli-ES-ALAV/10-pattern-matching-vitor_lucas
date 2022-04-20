class App{
    static int ite = 0;
    public static void main(String[] args) {
        String s1 = "ABCDCBDCBDACBDABDCBADF";
        String s2 = "ADF";

        System.out.println("Match com inicio em: " + searchOccurence(s1, s2) + "\nIteracoes: " + ite);
    }

    public static int searchOccurence(String s1, String s2){
        int cont1=0; int cont2=0; int beg=0;
        while(cont1 < s1.length()){
            ite++;
            if(cont2 == s2.length()) return beg;
            if(s1.charAt(cont1) == s2.charAt(cont2)){
                if(cont2==0) beg=cont1;
                cont2++;
            } 
            else {
                cont2=0;
                beg = 0;
            }
            cont1++; 
        }
        if(cont2 == s2.length()) return beg;
        return 0;
    }
}
