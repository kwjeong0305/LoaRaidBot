package org.asacoa.security;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.asacoa.security.AESdecrypt.decrypt;
import static org.asacoa.security.AESencrypt.encrypt;

public class SecController {
    private String key = "";
    private String token = "";

    public SecController() throws IOException {
        getToken();
    }

    // properties get key and token
    private void getToken() throws IOException {

        String propFile = "src/main/resources/conf/token.properties";

        Properties prop = new Properties();

        FileInputStream fis = new FileInputStream(propFile);

        prop.load(new java.io.BufferedInputStream(fis));

        key = prop.getProperty("key");
        token = prop.getProperty("token");
    }


    public String TokenEncrypt() {
        return encrypt(token.getBytes(), key.getBytes());
    }

    public String TokenDecrypt() {
        return decrypt(token.getBytes(), key.getBytes());
    }
}
