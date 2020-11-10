package com.example.mobliediagnosis.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PDFFunctionality {

    public static void makepdfv2(Context context, String data) {
        System.out.println("()()()() PHUL DATA: " + data);
        try {
            final File file = new File(context.getFilesDir() + "/sample.pdf");
            file.createNewFile();
            FileOutputStream fOut = new FileOutputStream(file);

            System.out.println("()()()() PATH: " + file.getAbsolutePath());

            PdfDocument document = new PdfDocument();
            PdfDocument.PageInfo pageInfo = new
                    PdfDocument.PageInfo.Builder(100, 100, 1).create();
            PdfDocument.Page page = document.startPage(pageInfo);
            Canvas canvas = page.getCanvas();
            Paint paint = new Paint();

            canvas.drawText(data, 10, 10, paint);


            document.finishPage(page);
            document.writeTo(fOut);
            document.close();

        } catch (IOException e) {
            System.out.println("()()()() ERROR: " + e.toString());
        }
    }

    public static void createMyPDF(Context context, String data){

        PdfDocument myPdfDocument = new PdfDocument();
        PdfDocument.PageInfo myPageInfo = new PdfDocument.PageInfo.Builder(300,1000,1).create();
        PdfDocument.Page myPage = myPdfDocument.startPage(myPageInfo);

        Paint myPaint = new Paint();
        String myString = data;
        int x = 10, y=25;
        for (String line:myString.split("\n")){
            myPage.getCanvas().drawText(line, x, y, myPaint);
            y+=myPaint.descent()-myPaint.ascent();
        }
        myPdfDocument.finishPage(myPage);

        String myFilePath = context.getFilesDir() + "/myPDFFile.pdf";
        File myFile = new File(myFilePath);
        System.out.println("()()()() SAVING PATH: " + myFile.getAbsolutePath());
        try {
            myPdfDocument.writeTo(new FileOutputStream(myFile));
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println(("error"));
        }
        myPdfDocument.close();
    }


}
