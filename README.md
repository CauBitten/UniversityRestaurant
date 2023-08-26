# ProjetoIP2

## Integrantes do grupo
* Lucas do Rêgo Maciel Pereira
* Higor Matheus da Costa Cordeiro
* João Guilherme Miranda de Sousa Bispo
* Cauã Ferraz Bittencourt
  
## Descrição Geral
Um sistema de gerenciamento de restaurante universitário, focado nas vendas de fichas e gerenciamento de usuários. O aplicativo poderá ser usado tanto pelos funcionários quanto pelos consumidores. Os serviços oferecidos são: compra de fichas, apresentação do cardápio, gerenciamento e cadastro de usuários do sistema, e apresentação de relatórios para o gerente.
Os usuários do tipo cliente possuem permissão de visualizar seu próprio perfil, sem modificá-lo, comprar fichas, ver o cardápio e verificar seu histórico de transações. Os usuários que são vendedores poderão cadastrar cardápios e realizar vendas quando for necessário o pagamento à dinheiro. Usuários com perfil de Gerente terão acesso a todos os relatórios, aprovarão os cardápios e farão o gerenciamento dos usuários e cardápios, sendo os únicos capazes de modificá-los. A realização das vendas e a apresentação do cardápio tornam-se mais importantes para o cliente, e gira em torno do objetivo principal do desenvolvimento do software.

## Requisitos do Projeto

* **REQ1** Validação de login - O sistema deve controlar o acesso através de login e senha. Os usuários do sistema poderão ser do tipo cliente, vendedor e gerente.
* **REQ2** Autorização de entrada ao restaurante - Sistema deve realizar a validação da possibilidade de entrada do cliente, por meio da apresentação da ficha de entrada, e liberar, ou não, a entrada no restaurante.
* **REQ3** Gerenciamento e cadastro do cardápio - O sistema deve permitir o gerenciamento CRUD do cardápio, que poderá ser realizado por usuários do tipo gerente. A visualização do cardápio em determinada data poderá ser realizada por usuários do tipo cliente e vendedor, porém, suas únicas permissões são de visualização.
* **REQ4** Realizar a venda de fichas - O sistema deve permitir a venda de fichas a um cliente, permitindo compras do tipo: cartão, Pix ou boleto.
* **REQ5** Gerenciamento e cadastro de usuários - O sistema deve permitir o gerenciamento CRUD de usuários, e esta ação só poderá ser realizada por perfis do tipo gerente.
* **REQ6** Realizar a apresentação dos perfis de usuário - Cada cliente terá um perfil, e o acesso às informações individuais será disponibilizado após a validação de acesso. E o gerente, após validadas suas permissões, terá acesso à visualização do perfil de todos os clientes e aos dados completos das vendas do restaurante.
* **REQ7** Filtragem dos dados - Os usuários com perfil de gerente terão direito a realizar a filtragem dos dados de usuários, cardápios, registros de compras e entradas. 
