package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class HaltCode extends ByteCode {
    @Override
    public void init(ArrayList<String> arg) {

    }

    @Override
    public void execute(VirtualMachine VM) { //Change the VM to stop running
       VM.setRunning(Boolean.FALSE);
    }
}
