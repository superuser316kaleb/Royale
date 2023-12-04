package com.example.demo2.reportes;

import com.example.demo2.dao.CanalDAOImpl;
import com.example.demo2.dao.FavoritosDAOImpl;
import com.example.demo2.modelo.Canal;
import com.example.demo2.modelo.Favoritos;
import com.example.demo2.modelo.Usuario;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PdfCanales {
    CanalDAOImpl canalesDao = new CanalDAOImpl();

    public void crearPdf(String destino) throws IOException {
        PdfWriter writero = new PdfWriter(destino);
        PdfDocument pdf = new PdfDocument(writero);

        Document document = new Document(pdf, PageSize.A4.rotate());
        document.setMargins(20, 20, 20, 20);

        PdfFont font = PdfFontFactory.createFont(StandardFonts.COURIER);
        PdfFont bold = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
        Table table = new Table(UnitValue.createPercentArray(new float[]{1, 1, 1,2,1,1,1}))
                .useAllAvailableWidth();

        process(table, null, bold, true);

        List<Map<Integer,String>> listaCanales = canalesDao.obtenerTodos();
        //Iterator it = listaCanales.keySet().iterator();
        for(Map<Integer,String> map:canalesDao.obtenerTodos()){
            process(table,map,font,false);
        }
        /*while (it.hasNext()) {
            process(table, listaCanales, font, false);
            it.next();
        }*/

        Paragraph title = new Paragraph("CANALES");
        title.setTextAlignment(TextAlignment.CENTER);
        title.setFont(bold);
        title.setFontSize(30);
        title.setFontColor(ColorConstants.BLUE);
        document.add(title);
        document.add(table);

        document.close();
    }

    public void process(Table table, Map<Integer,String> map, PdfFont font, boolean isHeader) {
        if (isHeader) {
            table.addHeaderCell(new Cell().add(new Paragraph("Canal").setFont(font)));
            table.addHeaderCell(new Cell().add(new Paragraph("Nombre").setFont(font)));
            table.addHeaderCell(new Cell().add(new Paragraph("Apellido").setFont(font)));
            table.addHeaderCell(new Cell().add(new Paragraph("Domicilio").setFont(font)));
            table.addHeaderCell(new Cell().add(new Paragraph("Telefono").setFont(font)));
            table.addHeaderCell(new Cell().add(new Paragraph("Usuario").setFont(font)));
            table.addHeaderCell(new Cell().add(new Paragraph("Email").setFont(font)));
        } else {
            table.addCell(new Cell().add(new Paragraph(String.valueOf(map.get(1))).setFont(font)));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(map.get(2))).setFont(font)));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(map.get(3)))).setFont(font));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(map.get(4)))).setFont(font));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(map.get(5)))).setFont(font));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(map.get(6)))).setFont(font));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(map.get(7)))).setFont(font));
        }
    }
}
