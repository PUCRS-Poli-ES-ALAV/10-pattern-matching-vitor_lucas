class App{
    static int iteSemHash = 0;
    static int iteComHash = 0;
    public static void main(String[] args) {
        String s1 = "ABCDCBDCBDACBDABDCBABCDCBDCBDACBDABDCBABCDCBDCBDACBDABDCBABCDCBDCBDACBDABDCBABCDCBDCBDACBDABDCBABCDCBDCBDACBDABDCBABCDCBDCBDACBDABDCBABCDCBDCBDACBDABDCBABCDCBDCBDACBDABDCBABCDCBDCBDACBDABDCBADF";
        String s2 = "ADF";

        System.out.println("Sem Hash: " + searchOccurrence(s1, s2) + "\nIteracoes: " + iteSemHash);
        System.out.println("Com Hash: " + search(s2, s1) + "\nIteracoes: " + iteComHash);
        KMP_String_Matching a = new KMP_String_Matching();
        System.out.println("KMPSearch: ");
        a.KMPSearch(s2, s1);
    }

    public static int searchOccurrence(String s1, String s2){
        int cont1=0; int cont2=0; int beg=0;
        while(cont1 < s1.length()){
            iteSemHash++;
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

    public static int search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        long patHash = hash(pat, M);
        for (int i = 0; i <= N - M; i++) {
            iteComHash++;
            long txtHash = hash(txt.substring(i, i+M), M);
            if (patHash == txtHash)
                return i; // ocorrência? colisão?
        }
        return N; // nenhuma ocorrência
    }

    public static long hash(String s, int M) {
        long h = 0;
        for (int j = 0; j < M; j++)
           h = (h * 32 + s.charAt(j)) % 2147483647;
        return h;
     }
}
