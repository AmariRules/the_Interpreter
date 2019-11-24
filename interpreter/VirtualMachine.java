package interpreter;

import interpreter.bytecode.ByteCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;
    private boolean isdumpOn = false;

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram(){
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<Integer>();
        isRunning = true;
        while(isRunning){
//            System.out.print("       ");      //Used for Debugging
            ByteCode code = program.getCode(pc);
            code.execute(this);
            if(isdumpOn){
            runStack.dump();
            }// Used to dump runstack state.
            //if(program.getCode(pc+1)!= null)
                pc++;
        }
    }
   // public void setRunStack(RunTimeStack RS){
   //     runStack = RS;
   // }
    public void setPc(int pc){
        this.pc = pc;
    }
   // public void setProgram(Program prog){
   //     this.program = prog;
   // }

    public void setRunning(Boolean setR){
        isRunning=setR;
    }
    public void setIsdumpOn(Boolean setD){
        isdumpOn = setD;
    }


    public void pushInt(Integer arg){
        runStack.push(arg);
    }


    public int popInt(){//Integer arg){
        return runStack.pop();
    }
    public void popFrame(){
        runStack.popFrame();
    }
    public void setNewFrameAt(int arg){
        runStack.newFrameAt(arg);
    }
    public void setReturnAddrs(int arg){
        returnAddrs.push(arg);
    }
    public int popReturnAddrs(){
        return (int)returnAddrs.pop();
    }
    public int store(int offset){
        return runStack.store(offset);
    }
    public int load(int offset){
        return runStack.load(offset);
    }
    public int getPC(){
        return pc;
    }
    public int maxSize(){
        return runStack.maxSize();
    }
    public int peek(){
        return runStack.peek();
    }

   // public void pushInt(Integer val)

}
