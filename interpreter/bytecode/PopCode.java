package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode {

    private int pops;
    @Override
    public void init(ArrayList<String> arg) {
    pops = Integer.parseInt(arg.get(0));
    }

    @Override
    public void execute(VirtualMachine VM) { //needs to set size as max available to pop

        int size = VM.maxSize()-1;

       if (pops<=size)
           size=pops-1;



        for (int i = 0; i< size; i++) { //change size to pops
            System.out.println(VM.popInt());

        }
    }
}
