package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class  WriteCode extends ByteCode {
    @Override
    public void init(ArrayList<String> arg) {

    }

    @Override
    public void execute(VirtualMachine VM) {
    System.out.print(VM.peek());
    }
}
