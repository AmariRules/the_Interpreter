package interpreter;

import interpreter.bytecode.*;

import java.util.ArrayList;

public class Program {

    private ArrayList<ByteCode> program;

    public Program() {
        program = new ArrayList<ByteCode>();
    }

    //this function returns the ByteCode at a given index.
    protected ByteCode getCode(int pc) {
       // System.out.print(pc);

        return this.program.get(pc);

    }


    public int getSize() {
        return this.program.size();
    }
    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * @param program Program object that holds a list of ByteCodes
     */

    //this function will resolve all symbolic addresses in the program.
    //Checks for instance of label code and changes the target inside to the labelcode for later using PC
    public void resolveAddrs() {
        for(ByteCode rAdd : program) {
            if (rAdd instanceof GotoCode) {
                for (int i = 0; i < program.size(); i++) {
                    if (program.get(i) instanceof LabelCode) {
                        if (((GotoCode) rAdd).getString().equals(((LabelCode) program.get(i)).getString())) {
                            ((GotoCode) rAdd).setInt(i);
                        }
                    }
                }
            }
            if (rAdd instanceof FalseBranchCode) {
                    for (int i = 0; i < program.size(); i++) {
                        if (program.get(i) instanceof LabelCode) {
                            if (((FalseBranchCode) rAdd).getString().equals(((LabelCode) program.get(i)).getString())) {
                                ((FalseBranchCode) rAdd).setInt(i);
                            }
                        }
                    }
            }
            if (rAdd instanceof CallCode) {
                    for (int i = 0; i < program.size(); i++) {
                        if (program.get(i) instanceof LabelCode) {
                            if (((CallCode) rAdd).getString().equals(((LabelCode) program.get(i)).getString())) {
                                ((CallCode) rAdd).setInt(i);
                            }

                    }
                }
            }
        }

    }

    public void setByteCode(ByteCode bc) {
        program.add(bc);
    }

}
