[![Stories in Ready](https://badge.waffle.io/Daniel-Aragao/TecI1_NP1.png?label=ready&title=Ready)](https://waffle.io/Daniel-Aragao/TecI1_NP1)
# TecI1_NP1
Repositório para desenvolvimento do trabalho da NP1 de Tecnologias de internet 1 com o professor Rafael Garcia

Cód. Disc.:	N554	     	Disciplina:	TECNOLOGIAS DE INTERNET I

Horário:	M35AB		Professor:	RAFAEL GARCIA BARBOSA


TRABALHO NP1 – 2016.1

Título do Trabalho

Sistema dos Correios

Objetivos do trabalho

Demonstrar habilidade para desenvolvimento de uma aplicação Java, utilizando:
•	Servlets
•	HTML
•	Javascript
•	CSS
•	Conceitos de Orientação a Objetos (interfaces, classes, herança, polimorfismo)
•	Bancos de Dados

Trabalho proposto

Elaborar uma aplicação para controle de objetos enviados pelos Correios. As funcionalidades do sistema estão especificadas abaixo. Os campos com asterisco (*) são obrigatórios (exibir mensagem de erro se não forem preenchidos).

1.	Menu Cadastrar Pessoa

Nesta opção, o sistema irá mostrar uma tela contendo um formulário para cadastro de um novo remetente/destinatário para envio/recebimento de objetos. A tela deverá exibir os seguintes campos:
- Nome* (caixa de texto);
- Rua* (caixa de texto);
- Número* (caixa de texto);
- Complemento (caixa de texto);
- Bairro* (caixa de texto);
- CEP* (caixa de texto com formatação para CEP);
- Estado* (combobox);
- Cidade* (combobox).
Ao exibir a página, o combo de cidade deve estar desabilitado. Após selecionar o estado, o combo de cidade deve carregar as cidades do estado selecionado e ficar habilitado. Após submeter o formulário, os dados devem ser armazenados no BD.

2.	Menu Buscar Pessoa (excluir/alterar)

Nesta opção, o sistema irá mostrar uma tela para o usuário buscar pessoas pelo nome. A tela exibirá uma caixa de texto e um botão. Após enviar o formulário, deverão ser buscadas todas as pessoas cujo nome possua, em qualquer parte, a string digitada pelo usuário. A lista de pessoas buscadas deve ser mostrada em uma tabela abaixo dos campos de pesquisa, com todos os campos exibidos em colunas, acrescidos de duas outras no formato de links: Alterar e Excluir.
Ao clicar no link Excluir, deverá ser exibida uma caixa de diálogo, perguntando se o usuário realmente deseja efetuar a operação. Caso ele responda que sim, o registro deverá ser excluído do BD.
Ao clicar no link Alterar, o usuário será encaminhado para uma página de alteração dos dados d pessoa selecionada, idêntica à página de cadastro, mas com todos os dados da pessoa preenchidos. O usuário poderá alterar qualquer informação e submetê-la para registro no BD.

3.	Menu Cadastrar Objeto

Nesta opção, o sistema irá mostrar uma tela contendo um formulário para cadastro de objetos a serem enviados pelos Correios. A tela deverá exibir os seguintes campos:
- Número* (caixa de texto);
- Remetente* (combo com as pessoas cadastrados no BD – exibir o nome e enviar o código);
- Destinatário* (combo com as pessoas cadastrados no BD – exibir o nome e enviar o código);
- Descrição do objeto* (área de texto);
- Peso* (caixa de texto);
- Dimensão* (três caixas de texto para informar a largura, a altura e profundidade);
- Valor (caixa de texto desabilitada, com botão ao lado, onde o valor calculado é mostrado após clicar no botão);
- Posto dos Correios de origem* (combo com os postos previamente cadastrados no BD – exibir o nome e enviar o código);
- Descrição da movimentação no posto de origem (área de texto).
Após preencher todos os campos, o usuário poderá clicar no botão de cálculo do valor a ser pago pela encomenda. O valor deve ser informado na caixa de texto desabilitada (via javascript) e é calculado da seguinte forma: 
- O valor padrão para envio de qualquer objeto é de R$ 50,00 (peso abaixo de 300g e soma da largura, altura e profundidade é menor que 100cm);
- Cada 100g em excesso custará R$ 5,00 a mais;
- Cada 100cm excedido custará R$ 5,00 a mais.
Após submeter o formulário, os dados devem ser armazenados no BD. Os dados da movimentação (posto de origem e descrição) devem ser armazenados em uma tabela separada, juntamente com a data/hora do sistema.

4.	Menu Encaminhar Objeto

Ao chegar em um posto (que pode ser um intermediário ou final), o funcionário poderá cadastrar uma movimentação para o objeto (seja para encaminhar a outro posto ou para enviar para entrega na casa do destinatário). Nesta opção, o sistema irá mostrar os seguintes campos:
- Objeto* (combo com os objetos cadastrados no BD – exibir a descrição e enviar o código);
- Posto dos Correios atual* (combo com os postos previamente cadastrados no BD – exibir o nome e enviar o código);
- Descrição da movimentação no posto atual* (área de texto).
Após submeter o formulário, os dados da nova movimentação devem ser armazenados no BD, juntamente com a data/hora do sistema.

5.	Rastrear Objeto

Nessa opção, o usuário poderá rastrear um objeto a partir de seu código. A tela deverá exibir um campo para informação do código e um botão de submissão. Após enviar o código, deverá ser exibida, na mesma página e abaixo do botão:
- Um espaço com as informações básicas do objeto (origem, destino, descrição, etc);
- Uma tabela com as movimentações ocorridas até o momento, sendo que cada movimentação deve estar em uma linha diferente da tabela e as colunas deverão exibir: o Posto, a Descrição da movimentação e a Data/Hora da Movimentação (formato dd/MM/yyyy HH:mm).


Equipe

Formada por no máximo 2 alunos.

Nota	

A nota do trabalho será de 0 (zero) a 10. Os alunos serão questionados sobre a implementação do sistema nos dias de entrega. O conhecimento de cada aluno sobre a implementação do sistema será usado na atribuição da sua nota de forma que a nota de cada aluno da equipe poderá ser diferente. 

Data de Entrega	
A data de entrega dos trabalhos será como previsto no plano de ensino.

Avaliação do trabalho

Serão cobrados no trabalho:
•	Funcionamento adequado segundo descrição do sistema (caso não funcione, serão abatidos pontos)
•	Utilização correta de conceitos da orientação a objetos e recursos do Java
•	Clareza do código (boa estruturação, comentários, etc)

