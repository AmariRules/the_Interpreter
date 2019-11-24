package interpreter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;
    private int counter = 0;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);


    }
    //Void function used to dump the current state of the
    //RuntimeStack. When printing the runtime stack make sure
    //to include divisions between frames. If a frame is
    //empty, this must be shown as well.
    public void dump(){
        ArrayList<Integer> stack = (ArrayList) runTimeStack.clone(); // Dump function
        Stack<Integer> framePtrs =  framePointer;
        ArrayList frameArray[] = new ArrayList[framePtrs.size()];

        for (int i = framePtrs.size(); i > 0; i--) {
            frameArray[i - 1] = new ArrayList<Integer>();
            int startIndex = framePtrs.get(i - 1);
            int currentSize = stack.size();
            for (int k = startIndex; k < currentSize; k++) {
                frameArray[i - 1].add(stack.remove(startIndex));
            }
        }
    for (int i = 0; i < framePtrs.size(); i++) {
        System.out.print(frameArray[i].toString());
    }
    System.out.println();
}


    //returns the top of the stack without removing the item.
    public int peek(){
        if (runTimeStack.size()==0)
            return runTimeStack.get(0);
        else
            return  runTimeStack.get(runTimeStack.size()-1);//can use runtimestack.get(runtimestack.size-1) // COME back to this
    }
    //removes an item from the top of the stack and returns it
    public int pop(){
        int temp = runTimeStack.get(runTimeStack.size()-1);
        runTimeStack.remove(runTimeStack.size()-1);
        return temp;
    }

    //used to add an item to the top of the RuntimeStack.
    //         Item added is also returned.

    public int push(int i){
        runTimeStack.add(i);
        return this.peek();
    }

    //  creates a new frame in the RuntimeStack class. The
    //         parameter offset is used to denote how many slots down
    //         from the top of RuntimeStack for starting a new frame.

    public void newFrameAt(int offset){

    framePointer.add((runTimeStack.size()) - offset);

    }
    //we pop the top frame when we return from a function.
//         Before popping, the function’s return value is at the
//         top of the stack, so we’ll save the value, then pop the
//         top frame and then push the return value back onto the
//         stack. It is assumed return values are at the top of
//         the stack.
    public void popFrame(){ // check logic
    int temp = runTimeStack.get(runTimeStack.size()-1);
        while (framePointer.peek() != runTimeStack.size()) {
        runTimeStack.remove(runTimeStack.size()-1);
    }

    framePointer.pop();
    runTimeStack.add(temp);
    }
    //Used to store values into variables. Store will pop the
    //         top value of the stack and replace the value at the
    //         given offset in the current frame. The value stored is
    //         returned.
    public int store(int offset) {
        int temp = framePointer.peek();
        int numB = pop();
        runTimeStack.set((temp+offset), numB);
        return temp;
    }

    //         Used to load variables onto the RuntimeStack from a
    //         given offset within the current frame. This means we
    //         will go to the offset in the current frame, copy the
    //         value and push it to the top of the stack. No values
    //         should be removed with load.
    public int load(int offset){
        int tempF = framePointer.peek();
        int val = runTimeStack.get(tempF);
    runTimeStack.add(val);

        return val;//// Alex showed me the way, Do you know the way?!/
    }
    //Used to load literal values onto the RuntimeStack. For
    //         example, LIT 5 or LIT 0 will call push with val being 5
    //         or val being 0.
    public Integer push(Integer val){
        runTimeStack.add(val);
        return peek();
    }
    public int maxSize(){
        Iterator iterator = framePointer.iterator();
        int pointToNextFrame = 0;
        int pointToCurrentFrame = (Integer)iterator.next();
        int frameSize =0;

        if(pointToCurrentFrame ==0) {
            frameSize = 0;

        }else if(iterator.hasNext()){
            pointToNextFrame = (Integer)iterator.next();
            frameSize = pointToCurrentFrame - pointToNextFrame;
        }
       return frameSize;
    }
}
