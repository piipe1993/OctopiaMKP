package co.com.grupoexito.octopia.models.VtexInfoProducto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Image {
    @JsonProperty("ImageUrl")
    private String ImageUrl;

    @JsonProperty("ImageName")
    private String ImageName;

    @JsonProperty("FileId")
    private int FileId;

}
