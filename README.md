# ProjetoIP2
## Integrantes do grupo
* Lucas do Rêgo Maciel Pereira
* Higor Matheus da Costa Cordeiro
* João Guilherme Miranda de Sousa Bispo
* Cauã Ferraz Bittencourt
## Descrição Geral
Um sistema de gerenciamento de restaurante universitário, focado nas vendas de fichas e gerenciamento de usuários. O aplicativo poderá ser usado tanto pelos funcionários quanto pelos consumidores. Os serviços oferecidos são: compra de fichas, apresentação do cardápio, gerenciamento e cadastro de usuários do sistema, apresentação de relatórios.
Os usuários consumidores são permitidos a acessar seu próprio perfil, sem modificá-lo, comprar fichas, ver o cardápio e verificar seu histórico de transações. Os usuários que são funcionários poderão cadastrar cardápios e  realizar as vendas. Usuários administradores terão acesso a todos os relatórios, aprovarão os cardápios e farão o gerenciamento dos usuários, sendo os únicos capazes de modificá-los. A realização das vendas e a apresentação do cardápio tornam-se mais importantes para o cliente, e gira em torno do objetivo principal do desenvolvimento do software.
## Requisitos do Projeto
* Validação de log-in - O sistema que deve controlar o acesso através de login e senha. Os usuários do sistema serão do tipo clientes, vendedores e gerentes.
* Autorização de entrada ao restaurante - Sistema deve receber um pedido com o cliente e a ficha para confirmar a entrada ao restaurante, aguardando uma reposta para liberação, ou não, da catraca.
*Apresentar o cardápio (diário, semanal ou mensal) - Esse sistema é editado pelo Gerente, e fica disponível apenas para visualização pelo acesso com contas do tipo cliente e vendedor.
*Realizar a venda de fichas - O sistema deve ser acessado pelo gerente ou vendedor, e cada ficha deve ser associada a um cliente.
* Gerenciamento e cadastro de usuários - O sistema deve permitir o gerenciamento CRUD(Create,Recover,Update e Delete) de clientes e vendedores, ação pode ser feito pelo gerente.
* Realizar a apresentação dos perfis de usuário - Cada cliente terá um perfil, e o acesso às informações individuais serão disponibilizadas após a validação de acesso. E o gerente, após checada suas credenciais como os clientes, terá acesso à visualização do perfil de todos os clientes e aos dados completos das vendas do restaurante.
*Apresentação de relatórios- O sistema apresentará ao cliente e ao gerente, relatórios com dados importantes de acordo com suas respectivas necessidades, e permissões de acesso.
