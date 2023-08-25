package com.example.musicsoup;

import javafx.collections.ObservableList;
import javafx.collections.ObservableList;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;

public class Creator {
    public static void documentCreation(ObservableList<Header> s,String str) throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.setFont(PDType1Font.HELVETICA_BOLD,12);
        contentStream.beginText();
        contentStream.newLineAtOffset(50,700);
        for(Header item:s)
            {contentStream.showText(String.valueOf(item));
                contentStream.newLineAtOffset(0, -20);
            }
        contentStream.endText();
        contentStream.close();
        document.save(str);
        }
    }

