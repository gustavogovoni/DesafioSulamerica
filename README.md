### Desafio Sulamérica
Avaliação técnica - Automação de uma plataforma de simulação e contratação de seguro de vida da SulAmérica.

### Critérios Utilizados 
Criação do Framework na linguagem Java, por se tratar da sintaxe de meu maior domínio, visto que é uma das linguagens mais utilizadas no mundo e as bibliotecas 
mais aplicadas do mercado como Cucumber, Selenium Webdriver e JUnit.

Projeto de automação de testes web na linguagem <b>Java</b> com <b>Maven</b> usando:

- JUnit 
- IntelliJ Idea 
- S.O. Windows 
- Cucumber
- Selenium WebDriver
- GIT

###### Projeto rodando no ChromeDriver 95.0.4638.54

Para outras versões do Chrome trocar o .exe na pasta <b>drivers<b> do projeto.

###### ChromeDriver Download: http://chromedriver.chromium.org/downloads

### Executando os testes

### Pré-requisito
Acesse o repositório Github e realize o download.
Se preferir clonar o projeto, indico o próprio site de ajuda do [GitHub](https://help.github.com/en/articles/cloning-a-repository)

Para baixar as dependências e rodar os testes pela primeira vez, executar o comando <b>maven clean install</b>


### Questionamentos Desafio
2- Dos cenários planejados, quais você acha que devem ser automatizados? Por que?  
Resposta: Daria prioridade no cenário que possui o fluxo principal da aplicação "Realizar contratacao seguro com sucesso", por se tratar
do "core" do sistema e que não deve deixar de funcionar por alguma modificação no sistema.
Obs.: Não automatizei o fluxo principal, pois a aplicação estava quebrando na tela 3.  
Utilizei como critério o cenário com um fluxo mais longo que envolvia mais passos
para demonstração.   

4- Você construiria cenários para validar o backend? Por que? Se sim, o que você validaria?  
Resposta: Sim, por se tratar de um teste mais rápido e barato, conforme o concieto da pirâmide de testes.Validaria a saúde da aplicação.



### Autor

Gustavo de Oliveira Govoni

### Licença

Projeto para avaliação técnica.