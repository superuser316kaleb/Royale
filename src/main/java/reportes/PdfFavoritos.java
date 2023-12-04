package reportes;

import com.example.demo2.dao.FavoritosDAOImpl;
import com.example.demo2.modelo.Favoritos;
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
import java.util.List;

public class PdfFavoritos {
    FavoritosDAOImpl favoritosDAO = new FavoritosDAOImpl();

    public void crearPdf(String destino) throws IOException {
        PdfWriter writer = new PdfWriter(destino);
        PdfDocument pdf = new PdfDocument(writer);

        Document document = new Document(pdf, PageSize.A4.rotate());
        document.setMargins(20, 20, 20, 20);

        PdfFont font = PdfFontFactory.createFont(StandardFonts.COURIER);
        PdfFont bold = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
        Table table = new Table(UnitValue.createPercentArray(new float[]{1, 1, 1}))
                .useAllAvailableWidth();

        process(table, null, bold, true);

        List<Favoritos> listaFavoritos = favoritosDAO.obtenerFavoritosPorUsuario();
        for (Favoritos favoritos : listaFavoritos) {
            process(table, favoritos, font, false);
        }

        Paragraph title = new Paragraph("FAVORITES");
        title.setTextAlignment(TextAlignment.CENTER);
        title.setFont(bold);
        title.setFontSize(30);
        title.setFontColor(ColorConstants.BLUE);
        document.add(title);
        document.add(table);

        document.close();
    }

    public void process(Table table, Favoritos favoritos, PdfFont font, boolean isHeader) {
        if (isHeader) {
            table.addHeaderCell(new Cell().add(new Paragraph("ID Favorito").setFont(font)));
            table.addHeaderCell(new Cell().add(new Paragraph("ID Usuario").setFont(font)));
            table.addHeaderCell(new Cell().add(new Paragraph("ID Video").setFont(font)));
        } else {
            table.addCell(new Cell().add(new Paragraph(String.valueOf(favoritos.getId_favorito())).setFont(font)));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(favoritos.getId_usuario())).setFont(font)));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(favoritos.getId_video())).setFont(font)));
        }
    }
}

