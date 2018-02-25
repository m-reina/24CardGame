package Game;
/** class of objects thrown when an operation to
  * add an element to a full stack is attempted
  */
class FullStackException extends StackException
{
    public FullStackException()
    {
        System.out.println("Stack is full! -- Invalid Operation");
    }
}

