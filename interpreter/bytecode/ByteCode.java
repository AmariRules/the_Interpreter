package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public abstract class ByteCode {

    public abstract void init(ArrayList<String> arg);
    public abstract void execute(VirtualMachine VM);
}
