Feature: Como usuario ya logeado quiero realizar una compra

  @Shopping
  Scenario Outline: el cliente busca un producto
    Given el cliente hace click en el buscador de productos
    When el cliente ingresa un <producto> en el buscador
    Then el cliente verifica que es redireccionado a la pantalla de resultados

    Examples:
        | producto |
        | dresses  |


  @Shopping
  Scenario: el cliente selecciona un producto
    Given el cliente se encuentra en la pantalla de resultados
    When el cliente hace click en un producto
    Then el cliente es redireccionado al producto que selecciono

  @Shopping
  Scenario Outline: el cliente selecciona las caracteristicas del producto
    Given el cliente se encuentra en la pantalla del producto que selecciono
    When elige la <cantidad> de productos
    And selecciona el <talle>
    And elige un <color>
    And hace click en el boton add to cart
    And hace click en proceed to checkout
    Then el cliente es redireccionado a la pantalla del carrito de compras

    Examples:
       | cantidad | talle | color    |
       | 1        | M     | color_14 |

  @Shopping
  Scenario Outline: el cliente compra un producto
    Given el cliente se encuentra en el carrito de compras
    When el cliente se encuentra en el summary y hace click en proceed to checkout
    And el cliente inicio sesion con <email> y <pass> y hace click en sing in
    And el cliente se encuentra en address y hace click en proceed to checkout
    And el cliente se encuentra en shipping y acepta los terminos de servicio y hace click en proceed to checkout
    And el cliente se encuentra en payment y elige la forma de pago
    Then el cliente confirma la compra haciendo click en I confirm my order

    Examples:
        | email                     | pass       |
        | fabrizio.aranda@gmail.com | contraseña |