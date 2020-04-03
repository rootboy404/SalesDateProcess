# SalesDateProcess
SalesDataProcess é um sistema de processamento de dados de vendas que importa arquivos .dat e processa mostrando 
seu número de cliente, vendedores, melhor venda e pior vendedor.

## Arquitetura
Ao iniciar o projeto ele verifica se existe algum arquivo **.dat** na pasta  ``` nomeUsurio/data/in ``` e cria o
processamento chamando a classe de serviço de processamento onde verifica cada dado no documento indicando para o serviço
respectivo de cada dado onde o mesmo iria processar e armazenar. No final ele encaminha os 
resultados para service resume onde ele monta um template e escreve em um arquivo **.done.dat** na pasta ``` nomeUsurio/data/out ```.
O sistema fica rodando em loop sempre aguardando novos dados para processar.   
O sistema foi Escrito em SpringBoot pela facilidade de iniciar o projeto e por rodar em um servidor que vem com o mesmo.

## Pré-requisitos
  - Editor de Código (intellij)
  - Java JDk 11
  - Gradle
  
## Bibliotecas utilizadas
  - Lombok
  - java.nio
  
## Executando o sistema
  Coloque os arquivos para o processamento de dados na pasta ``` /data/in ``` que deve ficar no seu diretório de usuário, 
  o arquivo processado estará na pasta ``` /data/out ```.O arquivo deve ser um **.dat** ou ao contrário não processara os 
  dados.
 
## Observações para executar
Para o projeto rodar é necessário alguns cuidados importantes.
- Criar no diretório de usuário as seguintes pastas ``` /data/in ```. Pois é onde ficara o aquivo de entrada.
- Criar no diretório de usuário as seguintes pastas ``` /data/out ```. Pois é onde ficara o aquivo de saída.
- Em distribuições Linux os arquivos de saída no diretório ``` /data/out ``` podem ficar ocultos, a solução para 
Distribuições baseadas em Ubuntu é executar o atalho *ctrl+h* para poder visualizar os arquivos.
- Em Sistemas Windows muito cuidado ao criar arquivos com bloco de notas porque o mesmo sempre fica com o formato **texto**
e não **dat** para execução em Windows esta disponível projeto  arquivo  ``` testeData.dat ```.


### Contato
```
Email :rafaelsilva.l1995@gmail.com
```
