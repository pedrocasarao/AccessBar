# AccessBar
Trabalho de fundamentos de desenvolvimento de software

Implemente o sistemas descrito abaixo utilizando uma arquitetura em 3 camadas. Em particular, implemente a camada de apresentação utilizando o framework Swing (do Java). Exercite as separação em camadas e a utilização dos padrões de projeto adequados.
Lembre-se: desenvolva os testes unitários para o seu código;
------------------------------------------------------------------------

O dono de uma rede de bares da cidade encomendou um sistema em Java para controlar o acesso de clientes ao bar. O proprietário deseja que, ao entrar no bar,  cliente informe:

seu nome, cpf, idade, gênero e se é um cliente VIP;
clientes VIP deve informar sua categoria (Silver, Gold ou Platinum).
A qualquer momento, ele deseja ser capaz de consultar quem são as pessoas que estão no bar, se alguém com um determinado CPF está no bar, quantas são as pessoas e qual a distribuição por gênero (percentual de clientes masculinos e femininos) e por categoria VIP. Ao sair, o cliente deve informar seu CPF, para registrar sua saída. Deve-se armazenar, em dois arquivos distintos, os dados dos clientes que entram, com a hora da entrada, e os dados dos clientes que saem, com a hora da saída (como se fossem dois registros de quem entrou e saiu, e quando).
