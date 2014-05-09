




public class MoveToFront {

    // apply move-to-front encoding, reading from standard input and writing to standard output
    public static void encode() {
        //char[] input = BinaryStdIn.readString().toCharArray();
        char[] order = new char[256];
        char max = 0;
        for (char i = 0; i < order.length; i++) 
            order[i] = i;
        while (!BinaryStdIn.isEmpty()) {
            char c = BinaryStdIn.readChar();
            if (c > max) 
                max = c;
            BinaryStdOut.write(indexOf(order, c, max));
            moveToFront(order, indexOf(order, c, max));
        }
        BinaryStdOut.flush();
    }


    // apply move-to-front decoding, reading from standard input and writing to standard output
    public static void decode() {
        char[] order = new char[256];
        char max = 0;
        for (char i = 0; i < order.length; i++) 
            order[i] = i;
        while (!BinaryStdIn.isEmpty()) {
            char c = BinaryStdIn.readChar();
            if (c > max) 
                max = c;
            BinaryStdOut.write(order[c]);
            moveToFront(order, indexOf(order, order[c], max));
        }
        BinaryStdOut.flush();
    }
    
    private static char indexOf(char[] order, char c, char max) {
        if (c > max) return order[c];
        for (char i = 0; i < order.length; i++) {
            if (order[i] == c)
                return i;
        }
        return (char) 0;            
    }
    
    private static void moveToFront(char[] order, char index) {
        if (index == 0) return;
        char c = order[index];
        System.arraycopy(order, 0, order, 1, index);
        order[0] = c;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
/*        try {
            System.setIn(new FileInputStream(args[1]));
            System.setOut(new PrintStream(new File(args[2])));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
           e.printStackTrace();
        } // need to delete
        */
        if (args[0].equals("-"))
            encode();
        else
            decode();
    }

}
