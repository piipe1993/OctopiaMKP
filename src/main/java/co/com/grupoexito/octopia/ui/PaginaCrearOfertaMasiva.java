package co.com.grupoexito.octopia.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class PaginaCrearOfertaMasiva extends PageObject {


    public static final Target BOTON_CREAR_ACTUALIZAR_OFERTAS = Target.the("Botón crear o actualizar ofertas")
            .locatedBy("//span[@role='button' and contains(text(),'Cree o actualice sus ofertas')]");

    public static final Target BOTON_SUBIR_ARCHIVO_OFERTA_MASIVA = Target.the("Botón subir Archivo")
            .locatedBy("//label[@for='UploadFileXlsViewData_browseFile' and contains(text(),'+ Subir archivo')]");

    public static final Target BOTON_ACEPTAR_OFERTA_MASIVA = Target.the("Botón aceptar")
            .locatedBy("//button[@name='uploadFile' and contains(text(),'Aceptar')]");

    public static final Target BOTON_CERRAR_OFERTA_MASIVA = Target.the("Botón cerrar")
            .locatedBy("//button[@class='btn btn-primary' and @data-dismiss='modal' and contains(text(),'Cerrar')]");

}
