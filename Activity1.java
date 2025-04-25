import java.util.Scanner;
// 02/07/2024
public class Activity1 {
    public static final String BLUE = "\u001B[34m";
    public static final String AQUA = "\u001B[36m";
    public static final String RESET = "\u001B[0m";
    
	public static void main(String[] args) throws Exception {
		int size;
		Scanner userinput = new Scanner(System.in);
		System.out.print("Hi! I'm Wyatt Marcus, before we begin, you must enter a number to adjust diamond size ");
		size = userinput.nextInt();
		
		if (size >= 100) {
			userinput.close();
			throw new Exception("Must be not greater than 100");
		}
		
		userinput.close();
	
		
		// Baseline implementation
		System.out.println("Control Diamond:");
		System.out.println("     *      ");
		System.out.println("    ***     ");
		System.out.println("   *****    ");
		System.out.println("  *******   ");
		System.out.println("   *****    ");
		System.out.println("    ***     ");
		System.out.println("     *      ");
		
		// Real Implementation
		System.out.println("Real Diamond");
        for (int i = 1; i <= size; i++) {
            // Print spaces
            // This subtracts the size by the iterator
            for (int j = 1; j <= size - i; j++) {
                System.out.print(" ");
            }
            
            // Print stars
            // This multiplies the iterator by 2 and subtracts by 1
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print(AQUA + "*" + RESET);
            }
            System.out.println();
        }
        
        // Lower half of diamond
        // The difference is the iterator just subtracted by 1
        for (int i = size - 1; i >= 1; i--) {
            // Print spaces
            for (int j = 1; j <= size - i; j++) {
                System.out.print(" ");
            }
            
            // Print stars
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print(BLUE + "*" + RESET);
            }
            System.out.println();
        }
	}

}
