package Game;
/** class of objects thrown when an operation to
  * access an element of an empty stack is attempted
  */
class EmptyStackException extends StackException 
{
    public EmptyStackException()
    {
        System.out.println("Stack is Empty! -- Invalid Operation");
    }
}
