#Author: Branda

@prova
Feature: Pesquisar programacao
  Eu como usuario quero realizar pesquisa para visualizar programacao atual 

@prova1
  Scenario: Validar o titulo da pagina lista de canais
    Given que eu esteja no "https://www.sky.com.br/"
    When acessar programacao atual
    And acessar lista de canais
    Then valido "Lista de Canais Completa da SKY | SKY" esta correta

   