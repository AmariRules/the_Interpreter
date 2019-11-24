package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode extends ByteCode {
   //private int addR;
    @Override
    public void init(ArrayList<String> arg) {

    }

    @Override
    public void execute(VirtualMachine VM) {

    VM.setPc(VM.popReturnAddrs());
     //addR = VM.peek();
    VM.popFrame();

    }

 //@Override
 //public String toString() { //Used for Dumping
 // return addR + "";
 //}
}
