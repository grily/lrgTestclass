package lrg;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class AESDemo {
    public static void main(String[] args) throws Exception {
        String key = "1ca4a36f752ca6a493f19405bbf72d28";
        // 生成一个AES密钥
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128); // 设置密钥长度为128位
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] keyBytes = secretKey.getEncoded();
        keyBytes = key.getBytes();

        // 生成一个随机的初始化向量
        String iv = "efa823df37062da0";
        byte[] ivBytes = iv.getBytes(); // 初始化向量长度为128位

        IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);

        // 使用AES密钥和初始化向量进行加密
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(keyBytes, "AES"), ivParameterSpec);
        String plainText = "18201143011";
        byte[] encryptedData = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
        String encryptedText = Base64.getEncoder().encodeToString(encryptedData);
        System.out.println("加密后的文本：" + encryptedText);
//        encryptedText = "0OSvKrDBFKtccjIgxVqYzg==";

        // 使用相同的AES密钥和初始化向量进行解密
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(keyBytes, "AES"), ivParameterSpec);
        byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        String decryptedText = new String(decryptedData, StandardCharsets.UTF_8);
        System.out.println("解密后的文本：" + decryptedText);
    }
}

