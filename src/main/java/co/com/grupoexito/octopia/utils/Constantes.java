package co.com.grupoexito.octopia.utils;

public class Constantes {

    public static final String GTIN_PRODUCTO_API_PRODUCTOS = "GTIN_PRODUCTO_API_PRODUCTOS";
    public static final String REFERENCIA_PRODUCTO_API_PRODUCTOS = "GTIN_PRODUCTO_API_PRODUCTOS";
    public static final String CLIENT_ID_API_PRODUCTOS = "Exito_demo";
    public static final String CLIENT_SECRET_API_PRODUCTOS = "41c58d2a-0f59-48d7-8f8f-a0d931fb2f18";
    public static final String GRANT_TYPE_API_PRODUCTOS = "client_credentials";
    public static final String BASE_URL_TOKEN = "https://auth.octopia-io.net";
    public static final String BASE_URL = "https://api.octopia-io.net/seller/v2";
    public static final String CODIGO_ALEATORIO = "CODIGO_ALEATORIO";
    public static final String RESPUESTA_GTIN_API_PRODUCTOS = "RESPUESTA_GTIN_API_PRODUCTOS";
    public static final String LISTA_GTIN = "LISTA_GTIN";
    public static final String BASE_URL_VTEX_EXITO = "https://exito.vtexcommercestable.com.br/api/catalog_system/pvt";
    public static final String APP_KEY_EXITO = "vtexappkey-exito-XOWKJO";
    public static final String APP_TOKEN_EXITO = "DNTCZZJGAWEFAACWXSKIMSKGYNPLOTRKNRXUZCGVATDWXCOEIUWCYJNVTDDJDWIHNINTRKGLVZZBYCVTQNIJZJDBWYNEZMKUHPSXDOXVPDBBQCVTHHNTJEGUQRDCDCCT";
    public static final String BASE_URL_VTEX_CARULLA = "https://carullaqa.vtexcommercestable.com.br/api/catalog_system/pvt";
    public static final String APP_KEY_CARULLA = "vtexappkey-carullaqa-IOXVHL";
    public static final String APP_TOKEN_CARULLA = "IGIYQGOHGUIODIGGFNKRLVGEWYHMLSCEARBVSFRVTAMIPDYYLVZAOFUNADCRZCWNRENLHLOAVPXLJXPTZJBPSCQUXOUPDZWREYQLPNQZHZEYIIDCOJRPAGVPNSNTQZWW";
    public static final String RUTA_ARCHIVO_CUERPO_CREAR_PRODUCTO = "src/test/resources/jsonDataTest/cuerpoCrearProducto";
    public static final String RUTA_ARCHIVO_CUERPO_CREAR_PRODUCTO_VARIANTE = "src/test/resources/jsonDataTest/cuerpoCrearProductoVariante.json";
    public static final String RUTA_ARCHIVO_EXCEL_PRODUCTOS_MASIVOS = "src/test/resources/excelDataTest/pdt_template_es-CO_pruebaMasiva";
    public static final String RUTA_ARCHIVO_EXCEL_OFERTAS_MASIVAS = "src/test/resources/excelDataTest/templateProduct10Masiva700085P1.xlsx";
    public static final String NOMBRE_PRODUCTO = "PRUEBA Empaque para Cafe OFERTA NUEVA NO VENDER";
    public static final String GTIN_PRODUCTO = "9535347687238";
    public static final String ID_PRODUCT_OCTOPIA = "ID_PRODUCT_OCTOPIA";



//CREACIÓN DE OFERTAS UNITARIAS Y MASIVAS
    public static final String SELLER_ID = "700085";
    public static final int CANTIDAD_GTIN_CARGA_UNITARIA = 1;
    public static final int CANTIDAD_GTIN_CARGA_MASIVA = 2;
    public static final int TIEMPO_CONSULTA_REINTENTOS_PRODUCTOS = 60;
    public static final String REFERENCIA_PRODUCTO = "EXITO05064";
    public static final String INVENTARIO_DISPONIBLE = "400";
    public static final String PRECIO_PRODUCTO = "5000";
    public static final String PRECIO_TACHADO = "8000";
    public static final String DESCRIPCION = "CAMPO PARA COLOCAR UNA DESCRIPCIÓN MÁS COMPLETA";
    public static final String GASTOS_ENTREGA_THD = "6000";
    public static final String GASTOS_ENTREGA_COMPLEMENTARIOS_THD = "2000";
    public static final String GASTOS_ENTREGA_SHD = "5000";
    public static final String GASTOS_ENTREGA_COMPLEMENTARIOS_SHD = "1000";
    public static final String PLAZO_PREPARACION = "2";



//QUERY PARA LAS TABLAS DE DYNAMO
    public static final String PARTITION_KEY = "pluExito";
    public static final String SORT_KEY = "";
    public static final String NOMBRE_TABLA_DYNAMO = "qa-dynadb-Product";


}
