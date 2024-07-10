# Sistema de Gerenciamento de Biblioteca


## Visão Geral

Este é um aplicativo desktop em Java para gerenciar dados sobre obras (livros e periódicos) em uma biblioteca. O aplicativo é projetado para armazenar e manipular dados sobre obras individuais, incluindo seus títulos, datas de publicação e localizações dentro da biblioteca.

## Estrutura de Classes

O aplicativo é construído em torno das seguintes classes:

### Obra

* Uma classe abstrata representando uma obra (livro ou periódico).
* Atributos: título, anoPublicação, mesPublicacao, localizacao

### Livro

* Uma classe que estende Obra, representando um livro.
* Atributos: ISBN, autor (além dos herdados de Obra)

### Periodico

* Uma classe que estende Obra, representando um periódico.
* Atributos: numero, subtitulo, numArtigos (além dos herdados de Obra)

### Localizacao

* Uma classe representando uma localização dentro da biblioteca.
* Atributos: numCorredor, numEstante, numPrateleira

## Funcionalidades

O aplicativo fornece uma interface de usuário para operações de criação, leitura, atualização e exclusão (CRUD) de obras e suas localizações. Os usuários podem:

* Criar novas obras (livros ou periódicos) com seus respectivos atributos
* Visualizar e editar obras existentes
* Atribuir localizações a obras
* Pesquisar obras por título, autor ou outros atributos

## Detalhes Técnicos

* O aplicativo é construído usando Java 21 e a biblioteca WindowBuilder para a interface gráfica de usuário.
* Os dados são armazenados na memória, mas podem ser facilmente adaptados para usar um banco de dados ou armazenamento de arquivos.

## Início Rápido

Para executar o aplicativo, basta clonar este repositório e executar a classe `CtrlPrograma`. O aplicativo será iniciado com uma interface de usuário para interagir com os dados.

## Licença

Este projeto é licenciado sob a Licença MIT. Veja o arquivo `LICENSE` para detalhes.