package ua.profitsoft;

public class Encrypt {
    public static void main(String[] args) {
        System.out.println(encrypt("01000111"));
    }

    public static String encrypt(String msg) {
        String encryptedMsg = "";

        int quantity = 0;
        while (msg.length() > 0) {
            msg = msg.substring(quantity, msg.length());
            if (msg.isEmpty()) break;
            quantity = getQuantity(msg);
            if (msg.charAt(0) == '0') {
                encryptedMsg = encryptedMsg + "00 " + zerosQuantity(quantity) + " ";
            } else {
                encryptedMsg = encryptedMsg + "0 " + zerosQuantity(quantity) + " ";
            }
        }
        return encryptedMsg.trim();
    }

    private static int getQuantity(String msg) {
        int index = 0;
        int quantity = 0;
        while (msg.charAt(0) == msg.charAt(index)) {
            quantity++;
            index++;
            if (index > msg.length() - 1) break;
        }
        return quantity;
    }

    private static String zerosQuantity(int quantity) {
        String result = "";
        for (int i = 0; i < quantity; i++) {
            result = result + "0";
        }
        return result;
    }
}
