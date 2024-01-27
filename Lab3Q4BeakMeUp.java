import java.util.Scanner;
/** 
 * ACS-1904 Lab3 Q4
 * @author: Sveinson (key)
*/

public class Lab3Q4BeakMeUp{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String st = "Beam me up Scotty.";
        
        // what code goes here
        
        System.out.println(st);
        
        /* nope none of these will work
         * the first two cause an error
         * the last one is not allowed as
         * defined in the instructions
         */
        //st.charAt(3) = 'K';
        //st.charAt(4) = 'K';
        //st = "BeaK me up Scotty.";
        
        //convert to mutable char array and edit
        char[] ch = st.toCharArray();
        ch[3] = 'K';

        // print the new string
        for(char c: ch)
            System.out.print(c);
            
        System.out.println();
        System.out.println("end of program");
    }
}
