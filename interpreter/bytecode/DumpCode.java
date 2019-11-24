package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode {
    Boolean Check = false;
    ArrayList<String> k;
    @Override
    public void init(ArrayList<String> arg) { //list of parameters of string
         k = arg;
    }
    @Override
    public void execute(VirtualMachine VM) {
        if(k.get(0).equals("ON")){
            Check = true;
            VM.setIsdumpOn(Check);
        }
        else if (k.get(0).equals("OFF")) {
            VM.setIsdumpOn(Check);
        }
    }
}

