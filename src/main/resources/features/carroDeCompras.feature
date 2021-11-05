# new feature
# Tags: optional

@FeatureName:RealizarCompraDeProductos
Feature: Yo como usuario quiero regístrame en la página y realizar la compra de dos productos.

  @ScenarioName:VerificacionDePrecios
  Scenario: Yo como usuario me registro y busco dos artículos de mi interés y los agrego al carrito de compras y este me debe dar el valor total.
    Given El usuario ingresa a la página automationpractice y va a sign in y crea un usuario con los datos solicitados y va home a para escoger los productos
    When El usuario escoge dos productos de su interés y los añade al carrito de compras.
    Then En el resumen de la lista de compras debe coincidir los valores de la suma de los productos más el envió con el que proporciona la página.




