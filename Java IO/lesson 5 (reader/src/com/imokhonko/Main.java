package com.imokhonko;

import java.io.*;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {

        donwloadInternetPage ("https://google.com");

    }


    private static void donwloadInternetPage(final String url) {

        InputStream siteURL = null;
        File tmpFile;
        File siteFile;
        OutputStream tmpStream = null;
        OutputStream indexStream = null;

        tmpFile = new File ("tmp.html");
        siteFile = new File ("index.html");

        try {
            siteURL = new URL(url).openStream ();

            tmpStream = new BufferedOutputStream (
                    new FileOutputStream (tmpFile));

            indexStream = new BufferedOutputStream (
                    new FileOutputStream (siteFile));

            int bytes;
            byte[] buffer = new byte[64 * 1024];

            while ((bytes = siteURL.read (buffer)) != -1) {
                tmpStream.write (buffer);
                indexStream.write (buffer);
                System.out.println ("downloaded bytes: " + bytes);
            }

        } catch (IOException e) {

            if(tmpFile.delete ()) System.out.println ("tmp file deleted");
            if(siteFile.delete ()) System.out.println ("tmp file deleted");

        } finally {

            // closing URL input stream
            if(siteURL != null) {
                try {
                    siteURL.close ();
                } catch (IOException e) {
                    System.out.println ("error closing URL");
                }
            }

            // closing tmp output stream
            if(tmpStream != null) {
                try {
                    tmpStream.flush ();
                    tmpStream.close ();
                } catch (IOException e) {
                    System.out.println ("error closing tmp output stream");
                }
            }

            // closing index output stream
            if(indexStream != null) {
                try {
                    indexStream.flush ();
                    indexStream.close ();
                } catch (IOException e) {
                    System.out.println ("error closing index output stream");
                }
            }
        }

    }
}
