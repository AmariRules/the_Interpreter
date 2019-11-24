package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LitCode extends ByteCode {
    ArrayList<String> Hold = new ArrayList<>();
private String holding = ""; // Used for ID and String Comments
    @Override
    public void init(ArrayList<String> arg) {

        Hold = arg;
    if (arg.size()>1)
        holding = arg.get(1);

    }

    @Override
    public void execute(VirtualMachine VM) {
    VM.pushInt(Integer.parseInt(Hold.get(0)));
    }
}
