package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode {
   // private ArrayList<String> arg0 = new ArrayList<String>();
    private int args;
    @Override
    public void init(ArrayList<String> arg) {
   // arg0= arg;
    args = Integer.parseInt(arg.get(0));

    }

    @Override
    public void execute(VirtualMachine VM) {
        VM.setNewFrameAt(args);

    }

}
