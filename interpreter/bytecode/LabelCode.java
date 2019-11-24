package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LabelCode extends ByteCode {
    private String Pie ;

    @Override
    public void init(ArrayList<String> arg) {
    Pie = arg.get(0);
    }

    @Override
    public void execute(VirtualMachine VM) {

    }
    public String getString(){
        return Pie;
    }
}
