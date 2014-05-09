import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;






public class BurrowsWheeler {
    
    // apply Burrows-Wheeler encoding, reading from standard input and writing to standard output
    public static void encode() {
        String input = BinaryStdIn.readString();
        CircularSuffixArray csa = new CircularSuffixArray(input);
        
        for (int i = 0; i < csa.length(); i++) {
         // search for first
            if (csa.index(i) == 0) {
                BinaryStdOut.write(i);
                break;
            }
        }
        
        for (int i = 0; i < csa.length(); i++) {
            // build t[]
            if (csa.index(i) == 0) {
                BinaryStdOut.write(input.charAt(csa.length() - 1), 8);
            }
            else {
                BinaryStdOut.write(input.charAt(csa.index(i) - 1), 8);
            }
        }
        
        BinaryStdOut.flush();
    }

    // apply Burrows-Wheeler decoding, reading from standard input and writing to standard output
    public static void decode() {

        //Stopwatch st = new Stopwatch();
        int first = BinaryStdIn.readInt();
        char[] t = BinaryStdIn.readString().toCharArray();
        int R = 256;        
        int N = t.length;
        int[] next = new int[N];
        int[] count = new int[R + 1];
        char[] aux = new char[N];
        for (int i = 0; i < N; i++)
            count[t[i]+1]++;
        
        for (int r = 0; r < R; r++)
            count[r+1] += count[r];
        
        for (int i = 0; i < N; i++) {
            next[count[t[i]]] = i;
            aux[count[t[i]]++] = t[i];
        }

        // use next[] and first
        // reconstruct the original input
        int k = first;
        for (int i = 0; i < t.length; i++) {
            BinaryStdOut.write(aux[k]);
            k = next[k];
        }

        //double a = st.elapsedTime();
        BinaryStdOut.flush();
    }

    // if args[0] is '-', apply Burrows-Wheeler encoding
    // if args[0] is '+', apply Burrows-Wheeler decoding
    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream(args[1]));
            System.setOut(new PrintStream(new File(args[2])));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } // need to delete


        if (args[0].equals("-"))
            encode();
        else
            decode();

    }

}
