package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LoadCode extends ByteCode {

    private int lc;
    private String ID;
    @Override
    public void init(ArrayList<String> arg) {
    lc = Integer.parseInt(arg.get(0));
        if(arg.get(1)!= null) {
            ID = arg.get(1);
        //System.out.println(lc + "BEFORE"+  ID + " LOAD CODE'S ID: "); //Used for Debugging
        }
    }

    @Override
    public void execute(VirtualMachine VM) {
    VM.load(lc);
    }

}
