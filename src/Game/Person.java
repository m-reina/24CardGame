package Game;

/**
 * Class Person
 * File Name : Person.java
 * Description : A Person class that holds a person's
 *               first name, last name, and age
 * Date : 02/09/2016
 * @see none
 * @author Natasha Efendy
 */
public abstract class Person {
    
    private String lastName;
    private String firstName;
    private int age;
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : Person()
     * Description: default constructor
     * Returns : none
     * Date: 02/9/2016
     * @param None
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */
    public Person()
    {
        lastName = " ";
        firstName = " ";
        age = 0;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : Person()
     * Description: overloaded constructor
     * Returns : none
     * Date: 02/9/2016
     * @param String first, string last, int age
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */
    public Person(String first, String last, int age)
    {
        lastName = last;
        firstName = first;
        this.age = age;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : setfirstName()
     * Description: set person's first name
     * Returns : none
     * Date: 02/9/2016
     * @param String first
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
     */
    public void setfirstName(String first)
    {
        firstName = first;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : getfirstName()
     * Description: get person's first name
     * Returns : string firstName
     * Date: 02/9/2016
     * @param None
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
     */
    public String getfirstName()
    {
        return firstName;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : setlastName()
     * Description: set person's last name
     * Returns : none
     * Date: 02/9/2016
     * @param String last
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
     */
    public void setlastName(String last)
    {
        lastName = last;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : getlastName()
     * Description: get person's last name
     * Returns : string lastName
     * Date: 02/9/2016
     * @param None
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
     */
    public String getlastName()
    {
        return lastName;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : setAge()
     * Description: set person's age
     * Returns : none
     * Date: 02/9/2016
     * @param int old
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
     */
    public void setAge(int old)
    {
        age = old;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : getAge()
     * Description: get person's age
     * Returns : string age
     * Date: 02/9/2016
     * @param None
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
     */
    public int getAge()
    {
        return age;
    }
}
