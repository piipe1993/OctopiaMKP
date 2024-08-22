package co.com.grupoexito.octopia.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static co.com.grupoexito.octopia.utils.Constantes.LISTA_GTIN;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ModificarGtinArchivoExcel implements Task {

    private String rutaArchivo;

    public ModificarGtinArchivoExcel(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<String> listaGtin = new ArrayList<>();
        listaGtin = actor.recall(LISTA_GTIN);
        try (FileInputStream fileInputStream = new FileInputStream(rutaArchivo);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {

            Sheet sheet = workbook.getSheetAt(0);//Hoja de excel

            int numeroFila = 9;
            int numeroCelda = 1;

            for (int k = 0; k < 2; k++) {
                for (int i = 0; i < listaGtin.size(); i++) {



                    Row row = sheet.getRow(numeroFila - 1);
                    Cell cell = row.getCell(numeroCelda - 1);

                    System.out.println("ESTE ES EL ELEMENTO "+ i +": " + listaGtin.get(i));
                    cell.setCellValue(listaGtin.get(i));
                    cell.setCellType(CellType.STRING);


                    try (FileOutputStream fileOutputStream = new FileOutputStream(rutaArchivo)) {
                        workbook.write(fileOutputStream);
                    }
                    numeroFila++;
                }

                numeroCelda++;
                numeroFila = 9;

            }


            System.out.println("Se ha modificado la celda en el archivo Excel (.xlsm).");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static ModificarGtinArchivoExcel conLaRuta(String rutaArchivo) {
        return instrumented(ModificarGtinArchivoExcel.class, rutaArchivo);
    }
}
