package org.asacoa.security;

import org.asacoa.log.Log;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.asacoa.security.AESdecrypt.decrypt;

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

        // key & token is empty exception
        if (key.equals("") || token.equals("")) {
            throw new IOException("key or token is empty");
        }
    }

    public String TokenDecrypt() {
        return decrypt(token.getBytes(), key.getBytes());
    }
}
