# Patterns Sample

Neste exemplo teremos como propósito melhorar um código que já existe, atendendo a algumas ideias do padrão 
[SOLID](https://en.wikipedia.org/wiki/SOLID).

## Principíos do SOLID

- **Single responsibility principle:** A class should only have a single responsibility, that is, only changes to one 
part of the software's specification should be able to affect the specification of the class.

- **Open–closed principle:** "Software entities ... should be open for extension, but closed for modification."

- **Liskov substitution principle:** "Objects in a program should be replaceable with instances of their subtypes 
without altering the correctness of that program." See also design by contract.

- **Interface segregation principle:** "Many client-specific interfaces are better than one general-purpose interface."

- **Dependency inversion principle:** One should "depend upon abstractions, [not] concretions."

## Questão

Temos uma API REST com Spring Boot. Nossa chamada recebe varios pagamentos e efetua calculos para enviar a um 
outro sistema de Tesouraria, onde bate os valores recebidos de um (ou mais) sistema com os valores recebidos de outras
fontes.

## Tarefas

### Exemplos de SOLID com calculos para Tesouraria

- [x] Aplicar melhorias diversas
- [x] Separar as responsabilidades das linhas (Interfaces/Abstrações)
- [x] Organizar responsabilidades por pacote (Public, Private, Protected)
- [ ] Adicionar calculos de linhas por Site (Factory/Strategy)
- [ ] Exemplos de reaproveitamento
