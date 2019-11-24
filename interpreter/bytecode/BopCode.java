package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class BopCode extends ByteCode {
    private String op;
    @Override
    public void init(ArrayList<String> arg) {
    op = arg.get(0);
    }

    @Override
    public void execute(VirtualMachine VM) {
    Integer op1 = VM.popInt();
    Integer op2 = VM.popInt();
    Integer temp = 0;

    if(op.equals("+")){
        temp = op2+op1;
    }else if(op.equals("-")){
        temp = op2 - op1;
    }else if(op.equals("/")){
        temp = op2 / op1;
    }else if(op.equals("*")){
        temp =op2 * op1;
    }else if(op.equals("==")){
       if(op1==op2)
           temp = 1;
       else temp = 0;

    }else if(op.equals("!=")){
        if(op1==op2)
            temp = 0;
        else temp = 1;
    }else if(op.equals("<=")){
        if (op2<= op1)
            temp =1;
        else
            temp =0;
    }else if(op.equals(">")){
        if (op2>op1)
            temp = 1;
        else
            temp =0;
    }else if(op.equals(">=")){
        if(op2>=op1)
            temp = 1;
        else
            temp =0;
    }else if(op.equals("<")){
        if(op2<op1)
            temp = 1;
        else
            temp =0;
    }else if(op.equals("|")){
        if(op2 == 0 && op1 ==0)
            temp =0;
        else
            temp =1;
    }else if(op.equals("&")){
        if(op2==1 && op1 ==1)
            temp =1;
        else
            temp =0;
    }
   // if(temp != 0)
   //     System.out.println("here lies temp" + temp); //Used for Debugging

    VM.pushInt(temp);

    }
}
