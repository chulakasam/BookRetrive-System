package com.example.BookRetrieveSystem.Util;

import java.util.Base64;

public class AppUtil {
    public static String BookImageOneToBase64(byte[] bytesBookImage) {
        return Base64.getEncoder().encodeToString(bytesBookImage);
    }


}
