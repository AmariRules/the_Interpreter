package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends ByteCode {
    private int target;
    String Pie;

    @Override
    public void init(ArrayList<String> arg) {
        Pie = arg.get(0);
    }

    @Override
    public void execute(VirtualMachine VM) {
    int temp = VM.popInt();

    if(temp==0)
        VM.setPc(target-1);
    }


    public String getString(){ return Pie; }

    public int getInt(){ return target; }

    public void setInt(int inte){ target = inte;}
}
