import java.security.SecureRandom;

public class Password {
    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:'\",.<>/?";

    public static String generatePassword(int length) {
        String allCharacters = UPPER_CASE + LOWER_CASE + DIGITS + SPECIAL_CHARACTERS;
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allCharacters.length());
            char randomChar = allCharacters.charAt(randomIndex);
            password.append(randomChar);
        }

        return password.toString();
    }

    public static void main(String[] args) {
        try {
            // Take user input for the desired length
            System.out.print("Enter the number of characters for the password: ");
            int length = Integer.parseInt(System.console().readLine());

            if (length <= 0) {
                System.out.println("Please enter a valid positive integer for the length.");
            } else {
                // Generate and display the password
                String password = generatePassword(length);
                System.out.println("Generated Password: " + password);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid positive integer.");
        }
    }
}
