package co.com.grupoexito.octopia.models;

import java.util.Map;

public class TipoProducto {

    private String tipoProducto;

    public TipoProducto(Map<String, String> tipoProducto) {
        this.tipoProducto = tipoProducto.get("tipoProducto");
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
}
