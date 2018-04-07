package helper;

import driver.WebDriverSingleton;

import java.io.IOException;

public class Helper {
    public static void closeBrowser() throws IOException {
        WebDriverSingleton.getInstance().close();
        WebDriverSingleton.destroyInstance();
    }
    public static String generateRandomString(int length, GeneratorMode mode) {
        StringBuffer buffer = new StringBuffer();
        String characters = "";
        switch (mode) {
            case ALPHA:
                characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
                break;
            case ALPHANUMERIC:
                characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
                break;
            case NUMERIC:
                characters = "1234567890";
                break;
            case ANY_CHARACTERS:
                characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890~!@#$%^&*()_+=-<>?/.,|}{][";
                break;
        }
        int charactersLength = characters.length();
        for (int i = 0; i < length; i++) {
            double index = Math.random() * charactersLength;
            buffer.append(characters.charAt((int) index));
        }
        return buffer.toString();
    }
}
