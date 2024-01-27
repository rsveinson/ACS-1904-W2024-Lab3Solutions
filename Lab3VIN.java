import java.util.Scanner;
/** 
 * ACS-1904 Lab 3 FormatPhoneNumber
 * Sveinson 
*/

public class Lab3VIN{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //String test = "s1d.20a0.A2.1234";
        //String test = "s1d.20a0.A2.123";
        //String test = "s1d.20a0.AC.123";
        //String test = "s1d.2000.AC.123";
        String test = "sEd.2000.aC.123";

        /* since StringBuilder overrides the inherited toString()
         * method we can explicitly call .toString() on our 
         * StringBuilder or we could implicitly call toString()
         * as in the line below
         */
        System.out.println(format(test));

        System.out.println("\nend of program");
    }// end main
    
    /*****************************************
    * Description: format a north american phone number
    * 
    * @param        String pn a phone number in the format LLL.DDDD.LD.LDDD
    * 
    * @return       StringBuilder formatted VIN
    * ****************************************/
    public static StringBuilder format(String pn){
        StringBuilder st = new StringBuilder();
        boolean valid = true;
        
        // check for length
        valid = pn.length() == 15;
        if(!valid)
            throw new IllegalArgumentException("VIN must have 15 characters.");
            
        // check for dots
        valid = pn.charAt(3) == '.' && pn.charAt(8) == '.' && pn.charAt(11) == '.';
        if(!valid)
            throw new IllegalArgumentException("Error: missing or incorrctly placed dots.");
            
        /* check the char and digit positions
         * split the string on "." and test each of the 
         * four tokens
         */
        // split the sting into tokens using one of these regular expressions
        //String[] tokens = pn.split("[.]+");
        String[] tokens = pn.split("\\.+");
        
        // test token 0: all letters
        for(int i = 0; i < tokens[0].length(); i++){
            if(!Character.isLetter(tokens[0].charAt(i))){
                valid = false;
            }// end if
        }// end for each
        
        // test tokens 2 all letters
        for(int i = 0; i < tokens[2].length(); i++){
            if(!Character.isLetter(tokens[2].charAt(i))){
                valid = false;
            }// end if
        }// end for each
        
        // test tokens 1: all digits
        for(int i = 0; i < tokens[1].length(); i++){
            if(!Character.isDigit(tokens[1].charAt(i))){
                valid = false;
            }// end if
        }// end for each
        
        // test tokesn 3: all digits
        for(int i = 0; i < tokens[3].length(); i++){
            if(!Character.isDigit(tokens[3].charAt(i))){
                valid = false;
            }// end if
        }// end for each
            
        if (!valid) 
           throw new IllegalArgumentException("missing or incorrct letters or digits.");
           
        // if we get to this point all of the checks have passed and the parameter is correct
        // also the input string has been split into tokes so
        // re-construct the string with StrinBuilder       
        
        // System.out.println(tokens.length);
        // System.out.println(tokens[0]);
        // System.out.println(tokens[1]);
        // System.out.println(tokens[2]);
        
        st.append(tokens[0].toUpperCase() + "-" + tokens[1] + "-" + tokens[2].toUpperCase() + "-" + tokens[3]);
                
        return st;
    }// end format
}
