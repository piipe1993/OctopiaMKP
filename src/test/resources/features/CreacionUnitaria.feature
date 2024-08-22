Feature: Se desea verificar la creación unitarria de productos y ofertas dentro de Octopia
  Y su posterior validación dentro del MDW Y VTEX

  @CreacionOfertaUnitaria
  Scenario Outline: Creación unitaria de productos y ofertas
    Given El usuario cargue un producto y su oferta correspondiente dentro del portal vendedor
      |  tipoProducto  |
      | <tipoProducto> |
    When se procesen y registren los datos en Dynamodb del producto unitario
    Then se debe visualizar el producto y la oferta unitaria en estado activo en VTEX

    Examples:
      |  tipoProducto  |
      |   NoVariante   |
      |    Variante    |