import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();

        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    public static void binary(int  item){
        int []data = {1,2,3,25,56,67,78,89};

        int start=0;
        int end=data.length;
        int middale=data.length/2;

    }
}
