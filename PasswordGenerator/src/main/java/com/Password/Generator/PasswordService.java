package com.Password.Generator;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PasswordService {

	private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";

    private final SecureRandom random = new SecureRandom();

    public String generatePassword(int length, boolean includeUpper, boolean includeLower, 
                                   boolean includeNumbers, boolean includeSymbols) {
        StringBuilder password = new StringBuilder();
        List<String> charCategories = new ArrayList<>();

        if (includeUpper) charCategories.add(UPPER);
        if (includeLower) charCategories.add(LOWER);
        if (includeNumbers) charCategories.add(NUMBERS);
        if (includeSymbols) charCategories.add(SYMBOLS);

        if (charCategories.isEmpty()) return "Debe seleccionar al menos una opción.";

        for (int i = 0; i < length; i++) {
            String charCategory = charCategories.get(random.nextInt(charCategories.size()));
            int position = random.nextInt(charCategory.length());
            password.append(charCategory.charAt(position));
        }

        return password.toString();
    }
}
