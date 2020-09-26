public class MyStack<T> {

    public StackNode<T> top;

    public T pop(){
        T value = top.data;
        top = top.next;
        return value;
    }

    public void push(T data){
        StackNode<T> newTop = new StackNode<>();
        newTop.data = data;
        newTop.next = top;
        top = newTop;
    }

    public StackNode<T> peek(){
        return top;
    }

    public boolean isEmpty(){
        return top==null;
    }
}
class StackNode<T>{
    StackNode next;
    T data;
}