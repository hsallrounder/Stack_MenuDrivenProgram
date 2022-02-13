public class StackByArray implements Stack {
    private int arr[];
    private int top;

    public int getTop() {
        return arr[top];
    }

    public int getSize(){
        return top+1;
    }

    public StackByArray(int size) {
        arr=new int[size];
        top=-1;
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public boolean isFull(){
        return top==arr.length-1;
    }

    public void push(int val) throws MyStackException{
        if(isFull()){
            throw new FullStackException();
        }
        else {
            arr[++top]=val;
        }
    }

    public int pop() throws MyStackException {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return arr[top--];
    }

    public void display() throws MyStackException{
        if(isEmpty()){
            throw new EmptyStackException();
        }
        else {
            for (int i = top; i >= 0; i--) {
                System.out.println(arr[i]);
            }
        }
    }

    public void displayRev() throws MyStackException{
        if(isEmpty()){
            throw new EmptyStackException();
        }
        else {
            for (int i=0;i<=top;i++){
                System.out.println(arr[i]);
            }
        }
    }
}
