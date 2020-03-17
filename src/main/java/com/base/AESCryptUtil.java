package com.base;


import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

/**
 * <p>AES加解密工具类</p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author lusp
 * @version 1.0
 * @date Created in 2018/9/15 11:42
 * @since 1.0
 */
public class AESCryptUtil {

    /**
     * 日志对象
     */
    private static final Logger logger = LoggerFactory.getLogger(AESCryptUtil.class);


    private static final String AESTYPE = "AES/ECB/PKCS5Padding";

    /**
     * AES秘钥
     */
    public static final String AES_KEY = "8w091ql5l2tt6qxj";

    /**
     * @param keyStr    密钥
     * @param plainText 加密数据
     * @return String 加密完数据
     * @Description: AES 加密
     */
    public static String AES_Encrypt(String keyStr, String plainText) {
        if (StringUtils.isBlank(plainText)) {
            return null;
        }
        byte[] encrypt = null;
        try {
            Key key = generateKey(keyStr);
            Cipher cipher = Cipher.getInstance(AESTYPE);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            encrypt = cipher.doFinal(plainText.getBytes());
        } catch (Exception e) {
            logger.error("error:{}", e);
        }
        return new String(Base64.encodeBase64(encrypt));
    }

    /**
     * @param keyStr      密钥
     * @param encryptData 解密数据
     * @return String
     * @Description: AES 解密
     */
    public static String AES_Decrypt(String keyStr, String encryptData) {
        if (StringUtils.isBlank(encryptData)) {
            return null;
        }
        byte[] decrypt = null;
        try {
            Key key = generateKey(keyStr);
            Cipher cipher = Cipher.getInstance(AESTYPE);
            cipher.init(Cipher.DECRYPT_MODE, key);
            decrypt = cipher.doFinal(Base64.decodeBase64(encryptData.getBytes()));
            String lastDecrypt = new String(decrypt);
            if (org.apache.commons.lang3.StringUtils.isNotBlank(lastDecrypt)) {
                return lastDecrypt.trim();
            }
        } catch (Exception e) {
            logger.info("AES解密失败,encryptData:{},error:{}", encryptData, e);
        }
        return null;
    }


    /**
     * @param key
     * @param @throws Exception
     * @Description: 封装KEY值
     */
    private static Key generateKey(String key) throws Exception {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
            return keySpec;
        } catch (Exception e) {
            logger.error("error:{}", e);
            throw e;
        }

    }

    public static void main(String[] args) {
        String shengchanKey = AES_KEY;

        try {
		    String userId = "42065630460181";
		    String en = AES_Encrypt(shengchanKey,userId);
		    System.out.println("加密："+en);
            String de = AES_Decrypt(shengchanKey, en);
            System.out.println("解密：" + de);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}