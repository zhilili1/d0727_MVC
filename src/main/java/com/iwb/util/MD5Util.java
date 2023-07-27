package com.iwb.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    public  static  String getMD5(String password)
    {
        try {
            MessageDigest digest =MessageDigest.getInstance("md5");
            byte [] result =digest.digest(password.getBytes());
            StringBuilder builder =new StringBuilder();
            //每个字节与0xff做与运输

            for (byte b:result) {
                int number =b&0xff;
                String str =Integer.toHexString(number);
                if (str.length()==1)
                {
                    builder.append("0");
                }
                else {
                    builder.append(str);
                }

            }
            return builder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
