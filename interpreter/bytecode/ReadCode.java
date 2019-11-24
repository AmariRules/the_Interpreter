package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReadCode extends ByteCode {
    private String inp;
    @Override
    public void init(ArrayList<String> arg) {

    }

    @Override
    public void execute(VirtualMachine VM) {

        try{
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter a number:\n");
             inp = input.readLine();
            int n = Integer.parseInt(inp);
            VM.pushInt(n);
        }catch(Exception e){
            System.out.print("Input Error");
        }
    }
}
