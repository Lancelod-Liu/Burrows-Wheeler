





public class CircularSuffixArray {
    private int length;
    private int[] index;
    
    // circular suffix array of s

    public CircularSuffixArray(String s) {
        length = s.length();
        index = new int[length];
        SuffixArrayX sax = new SuffixArrayX(s); 
        // initial the index
        for (int i = 0; i < length; i++) {
            index[i] = sax.index(i);
        }   
    }  

    public int length() {                  // length of s
        return length;
    }
    
    public int index(int i) {               // returns index of ith sorted suffix
        return index[i];
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
/*        try {
            System.setIn(new FileInputStream(args[0]));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Stopwatch st = new Stopwatch();
        CircularSuffixArray csa = new CircularSuffixArray(BinaryStdIn.readString());
        StdOut.println(st.elapsedTime());*/
    }

}
