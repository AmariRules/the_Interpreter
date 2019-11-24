
package interpreter;

import interpreter.bytecode.ByteCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class ByteCodeLoader extends Object {

    private StringTokenizer tokenizer;
    private BufferedReader byteSource;
    
    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN LOADCODES.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab THE correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() {
        CodeTable.init();
        Program nProgram = new Program();


    try {
       while (byteSource.ready()) {

        String token = byteSource.readLine();
        tokenizer = new StringTokenizer(token);

          String className = CodeTable.getClassName(tokenizer.nextToken());
           Class c = Class.forName("interpreter.bytecode."+className);

           ByteCode bc = (ByteCode) c.getDeclaredConstructor().newInstance();
           ArrayList<String> st = new ArrayList<String>();
        while(tokenizer.hasMoreTokens()) {
            st.add(tokenizer.nextToken());
        }
           bc.init(st);
           nProgram.setByteCode(bc);

     }
    }catch(Exception e){

        }
        nProgram.resolveAddrs();
        return nProgram;
    }
}
