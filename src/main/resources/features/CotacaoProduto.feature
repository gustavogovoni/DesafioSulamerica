#language:pt


Funcionalidade: Realizar cotação seguro vida

  Como um cliente
  Eu quero realizar a cotação de um seguro de vida
  Para que eu possa realizar a cotratação no site

  @1ºCenário
  Esquema do Cenario: Realizar contratacao seguro com sucesso.

    Dado que estou no site na opcao de simulacao
    Quando preencho os campos "<nome>" "<data>" "<ocupacao>"
    E prossigo para os canais de contato
    E valido se o nome no cabecalho esteja correto
    E preencho os canais de contato "<telefone>" "<email>"
    E autorizo um corretor a entrar em conato comigo
    E prossigo para encontrar meu seguro
    E seleciono um produto
    E contrato o seguro
    Então valido se foi exibidaa tela para informar dados pessoais

    Exemplos:
      |nome	        |data	    |ocupacao|telefone      |email             |
      |JOAO DA SILVA|03/01/1990	|ACROBATA|(11) 2233-4455|teste@teste.com.br|


  @2ºCenário
  Esquema do Cenario: Realizar contratacao sem informar dados pessoais.

    Dado que estou no site na opcao de simulacao
    Quando preencho os campos "<nome>" "<data>" "<ocupacao>"
    E prossigo para os canais de contato
    Então valido se os campos nome,data e ocupacao foram validados

    Exemplos:
      |nome	        |data	    |ocupacao|
      |             |       	|        |

  @3ºCenário
  Esquema do Cenario: Realizar contratacao sem informar contatos e autorizacao.

    Dado que estou no site na opcao de simulacao
    Quando preencho os campos "<nome>" "<data>" "<ocupacao>"
    E prossigo para os canais de contato
    E valido se o "<nome>" no cabecalho esteja correto
    E prossigo para encontrar meu seguro
    Então valido se a mensagem de alerta é apresentada ao usuário

    Exemplos:
    |nome	        |data	    |ocupacao|     
    |JOAO DA SILVA  |03/01/1990	|ACROBATA|
