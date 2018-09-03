package com.raju.library.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author raju
 */
public class StringUtils {

    public static List<String> convertStringToArray(String value) {
        List<String> lines = new BufferedReader(new StringReader(value))
                .lines()
                .collect(Collectors.toList());
        return lines;
    }

    public static String[] convertStringToArrayTest(String Value) {
        String[] inputSplitNewLine = Value.split("\n");
        return inputSplitNewLine;
    }

    public static List<String> convertToList(String value) {
        List<String> strings = new ArrayList<>();
        return strings;

    }

    public static String convertArrayToString(String[] strings) {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            buffer.append(strings[i]);
            if (i < strings.length - 1) {
                buffer.append("\n");
            }
        }
        return buffer.toString();
    }

    public static List<String> returnActualFile(String[] strings) {
        List<String> list = new ArrayList<>();
        String[] actualArray;
        if (strings[0].contains("BEGIN PRIVATE KEY")) {
            actualArray = Arrays.copyOfRange(strings, 1, strings.length-1);
        } else {
            actualArray = Arrays.copyOfRange(strings, 0, strings.length);
        }
        list = Arrays.asList(actualArray);
        return list;
    }

    public static void main(String[] args) throws IOException {
        String key = "-----BEGIN PRIVATE KEY-----\nMIICwAIBADANBgkqhkiG9w0BAQEFAASCAqowggKmAgEAAoGRALy6550JJcwO/VZc\nfpd090JUCYYjvOCEViFNoZLlS4xmKN64qgoW/6ak376pnZcPv1B5L3Z3+byX5tXv\n1IJMEriNc7bqvebj4oRTRbcpElgzOy8WjQg7BqbnYSgnIr2z2K9/69uQzho7ZS6o\nWswKmBmlJ0mZt/xVgk/MITLfWTujwzsI5fIgQMbkVTjXAoYuFwIDAQABAoGRAJga\nQiRLhQzKX95EOTozaDsqo2paTxTbUtcQS9GpvpNumi21wkTTeEKDyldNN9bROCzR\nHjFqS/l0qvNskGZajRPz3HhlA5ubuEbzUi1dbkDfTcgDbR471xTKb5bF/yFsHoJi\nb34U4JTfreDUSyHkEkMahwomHvnUKyLtECy4tfJRZ+i92okSKPANCTU7SaXxYQJJ\nAOAQl9/pVv5z7xvRUWr2ahjjpV78YBF6L0z069VgifIehXbxhjs5XyKuHdhMRFj6\nRfBNus9EjJsWrHlXaFxiS0Xf28BRN6e5aQJJANehD5Grcx8hvixLK2r4/pzgl5fv\nVreb9yeey48+16Cr8GXhIjiDCF1a99rhXKUddo8MxnHUqFa6MUIlLaME28GvHZzB\nUSY7fwJJAJ69Yruxdn5i6D2O992NofDsJpa6udzn8WbWBdZvxIsR8IAp8G044huR\nu3cn4Swgczgh+X0qFWsyjxKQSFFbGfTw+aCwaXucMQJIXVD8deQm3BA0RuL5FUBQ\nn/+qWzxe4PMEUQctvP5LPuNqFA0MTDyYwB4AKZ9iAqrvhhTXRKfteir16lRAnc4a\ndIWeYRpgThVtAkkA2tdbfIjF93jafdJrNE5VEC6/pVsZNmTPD2hrdVs1hgNUtEDr\nPdqNwWcJpWrN2tAPsNZXJVGAM+YYb0oEEHixBOdJS1Ql+5a4\n-----END PRIVATE KEY-----";
        List<String> list =StringUtils.returnActualFile(StringUtils.convertStringToArrayTest(key));
        Path path = Paths.get("/home/raju/ABR/test/test2.txt");
        Files.write(path, list, Charset.forName("UTF-8"));
        System.out.println("DONE");
    }

}
