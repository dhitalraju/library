package com.raju.library.converter;

import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author raju
 */
public class UnicodeConverter {

    public static String unescapeJava(String unicode) {
        if (!unicode.contains("\\u")) {
            return unicode;
        }

        String processed = "";

        int position = unicode.indexOf("\\u");
        while (position != -1) {
            if (position != 0) {
                processed += unicode.substring(0, position);
            }
            String token = unicode.substring(position + 2, position + 6);
            unicode = unicode.substring(position + 6);
            processed += (char) Integer.parseInt(token, 16);
            position = unicode.indexOf("\\u");
        }
        processed += unicode;

        return processed;
    }

    public static String convertHexToString(String hex) {

        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        //49204c6f7665204a617661 split into two characters 49, 20, 4c...
        for (int i = 0; i < hex.length() - 1; i += 2) {

            //grab the hex in pairs
            String output = hex.substring(i, (i + 2));
            //convert hex to decimal
            int decimal = Integer.parseInt(output, 16);
            //convert the decimal to character
            sb.append((char) decimal);

            temp.append(decimal);
        }
        System.out.println("Decimal : " + temp.toString());

        return sb.toString();
    }

    public static String toHexString(String str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            sb.append(toHexString(str.charAt(i)));
        }
        return sb.toString();
    }
    
    public static String toHexString(char ch) {
    String hex = Integer.toHexString((int) ch);
    while (hex.length() < 4) {
      hex = "0" + hex;
    }
    hex = "\\u" + hex;
    return hex;
  }
    
    public static String convertToHexString(String unicodeString)
     {
          char[] chars = unicodeString.toCharArray();
          StringBuffer output = new StringBuffer();
          for(int i = 0; i < chars.length; i++)
          {
               output.append(Integer.toHexString((int)chars[i]));
          }
          return output.toString();
     }

     public static String convertToUnicodeString(String hexString)
     {
          StringBuffer output = new StringBuffer();
          String subStr = null;
          for (int i =0 ; i < hexString.length() ;i=i+2 )
          {
               subStr = hexString.substring(i,i+2);
               char c = (char) Integer.parseInt(subStr, 16);
               output.append(c);
          }
          return output.toString();
     }

    public static void main(String[] args) {

        //option 1
        String utf8Text = "\u0627\u0644\u0628\u0646\u0643 \u0627\u0644\u0645\u062a\u062d\u062f";
        byte[] bytes = utf8Text.getBytes(StandardCharsets.UTF_8);
        String text = new String(bytes, StandardCharsets.UTF_8);
        System.out.println("TEXT :: " +text);
        //option 2
//        String myString = "\u0627\u0644\u0628\u0646\u0643 \u0627\u0644\u0645\u062a\u062d\u062f";
//        try {
//            JSONObject json = new JSONObject();
//            json.put("string", myString);
//            String converted = json.getString("string");
//            System.out.println("Converted String ::: " +converted);
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
        //option 3
//        String myString = "\u0627\u0644\u0628\u0646\u0643 \u0627\u0644\u0645\u062a\u062d\u062f";
//        StringBuilder builder = new StringBuilder();
//        myString.chars().forEach(a -> System.out.print((char)a));
        //option 4
//        String myString = "\u0627\u0644\u0628\u0646\u0643 \u0627\u0644\u0645\u062a\u062d\u062f";
//        System.out.println("Converted ::: " + UnicodeConverter.unescapeJava(myString));
        //option 5
//        String string = "\u2325";
//        UnicodeConverter.convertHexToString(string);

        //option 6
//        char c = 'क';
//        System.out.println("HEX Value ::: " +UnicodeConverter.toHexString(c));
//        String string = UnicodeConverter.toHexString(c);
//        System.out.println("Converted Value :: " +unescapeJava(string));

        
//        String uniCodeChar ="البنك المتحد";
//        StringBuffer buffer = new StringBuffer();
//        char[] cs = uniCodeChar.toCharArray();
//        for(int i = 0; i< cs.length; i++){
//            buffer.append(UnicodeConverter.toHexString(cs[i]));
//        }
//        System.out.println("Converted :: " +buffer.toString());
    }
}
