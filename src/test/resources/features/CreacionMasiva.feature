Feature: Se desea verificar la creación masiva de productos y ofertas dentro de Octopia
        Y su posterior validación dentro del MDW Y VTEX

  @CreacionOfertaMasiva
  Scenario Outline: Creación masiva productos y ofertas
    Given El usuario cargue los archivos de productos y ofertas dentro del portal vendedor
      | tipoProducto   |
      | <tipoProducto> |
    When se procesen y registren los datos en Dynamodb
    Then se deben visualizar los productos y ofertas en estado activo en VTEX

    Examples:
      | tipoProducto |
      | NoVariante   |
#      |  Variante    |