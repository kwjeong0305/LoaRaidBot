package org.asacoa.security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AESdecrypt {

    public static String decrypt(byte[] target, byte[] key) {
        SecretKeySpec keySpec = null;

        keySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {

            return null;
        } catch (NoSuchPaddingException e) {
            return null;
        }

        try {
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
        } catch (InvalidKeyException e) {

            return null;
        }

        try {
            Base64.Decoder encoder = Base64.getDecoder();
            return new String(cipher.doFinal(encoder.decode(target)));
        } catch (IllegalBlockSizeException e) {
            System.out.println("err");
        } catch (BadPaddingException e) {

        }
        return null;
    }

}
