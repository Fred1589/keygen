package com.fb.tools.keygen.aes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AESKeyGenerator {

	public static void main(String[] args) {
		try {
			generateKey();
		} catch (NumberFormatException | NoSuchAlgorithmException e) {
			System.err.println("Failed to generate AES key");
			e.printStackTrace();
			System.exit(0);
		}
	}

	private static void generateKey() throws NoSuchAlgorithmException {
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(256);
		SecretKey secretKey = keyGen.generateKey();
		byte[] encoded = secretKey.getEncoded();
		try (FileOutputStream fileOuputStream = new FileOutputStream("keyfile")) {
            fileOuputStream.write(encoded);
        } catch (IOException e) {
        	System.err.println("Failed to write keyfile");
			e.printStackTrace();
			System.exit(0);
        }
	}

}
