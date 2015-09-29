package com.turbo.volleyokhttp.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;


public class XlmEncryption {

	

	/**
	 * @param password (MD5)
	 * @return
	 */
	public static String encryptPassword(String password)  {
		try {
			int iterations = 1000;
			char[] chars = password.toCharArray();
			byte[] salt = getSalt().getBytes();

			PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
			SecretKeyFactory skf = SecretKeyFactory
					.getInstance("PBKDF2WithHmacSHA1");
			byte[] hash = skf.generateSecret(spec).getEncoded();
			return iterations + ":" + toHex(salt) + ":" + toHex(hash);
		} catch (Exception e) {
			return "";
		}
	}

	private static String getSalt() throws NoSuchAlgorithmException {
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		byte[] salt = new byte[16];
		sr.nextBytes(salt);
		return salt.toString();
	}

	private static String toHex(byte[] array) throws NoSuchAlgorithmException {
		BigInteger bi = new BigInteger(1, array);
		String hex = bi.toString(16);
		int paddingLength = (array.length * 2) - hex.length();
		if (paddingLength > 0) {
			return String.format("%0" + paddingLength + "d", 0) + hex;
		} else {
			return hex;
		}
	}

	public static boolean validatePassword(String unEncryptedPassword,String encryptedPassword) {
		try {
			String[] parts = encryptedPassword.split(":");
			int iterations = Integer.parseInt(parts[0]);
			byte[] salt = fromHex(parts[1]);
			byte[] hash = fromHex(parts[2]);

			PBEKeySpec spec = new PBEKeySpec(unEncryptedPassword.toCharArray(),
					salt, iterations, hash.length * 8);
			SecretKeyFactory skf = SecretKeyFactory
					.getInstance("PBKDF2WithHmacSHA1");
			byte[] testHash = skf.generateSecret(spec).getEncoded();

			int diff = hash.length ^ testHash.length;
			for (int i = 0; i < hash.length && i < testHash.length; i++) {
				diff |= hash[i] ^ testHash[i];
			}
			return diff == 0;

		} catch (Exception e) {
			return false;
		}
	}

	private static byte[] fromHex(String hex) throws NoSuchAlgorithmException {
		byte[] bytes = new byte[hex.length() / 2];
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2),
					16);
		}
		return bytes;
	}

	
	public static String MD5(byte[] data){
		String sReturnCode = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(data);
			byte b[] = md.digest();
			int i;
			StringBuffer sb = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0) {
					i += 256;
				}
				if (i < 16) {
					sb.append("0");
				}
				sb.append(Integer.toHexString(i));
			}

			sReturnCode = sb.toString();
		} catch (Exception ex) {
		}
		return sReturnCode;
		
		
	}
	
	/**
	 * MD5加密
	 * 
	 * @param sStr
	 * @return String
	 */
	public final static String MD5(String sStr) {
		try {
			return MD5(sStr.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
		}
		return "";
	}

}
