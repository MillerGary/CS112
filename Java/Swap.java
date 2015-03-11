public class Swap
{
    public static void main (String[] args)
    {
        int a = 10;
        int b = 5;
        String value;

        System.out.println("The value of a is: " +a);
        System.out.println("The value of b is: " +b);

        swap(a, b);

        System.out.println(value);
        //System.out.println("The value of b is: " +b);



    }
     public static String swap(int a, int b)
        {
            int temp = 0;
            temp = a;
            String value = "Nothing";
            a = b;
            b = temp;
            value = ("The value of a is:" +a +"The value of b is:" +b);
            return value;

        }


}
