package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class StoreCode extends ByteCode {
    private int N;
    private int Hold;
    private String id; //Used for dumping and comments only, variable name where the data is loaded.

    @Override
    public void init(ArrayList<String> arg) {
    N = Integer.parseInt(arg.get(0));
    if(arg.get(1)!=null)
        id = arg.get(1);
    }

    @Override
    public void execute(VirtualMachine VM) {

   // Hold = VM.peek(); //
     //   System.out.println(N + "arg0");
     //   System.out.println(id + "arg1");
    VM.store(N);
    //System.out.println("Gap:"+VM.store(N));// Used for Dumping And ToString
    }

}
