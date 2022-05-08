<h1 id="nome-do-projeto" align="center">CADASTRO DE USUARIO</h1>

  - 🤖 [Tecnologias](#tecnologias)
  - 🎊 [Features](#features)
  - 🌍 [Requisições](#requisicoes)
  - ⚓ [Configuração](#config)
    


<h2 id="tecnologias">🤖 Tecnologias/Ferrramentas</h2>

- **Java 8**
- **Eclipse**
- **WindowBuilder**
- **MySql**

<h2 id="features">🎊 Features</h2>
<h4>🎇 Finalizados</h4>

- [x] Feature Incluir
- [x] Feature Alterar
- [x] Feature Excluir
- [x] Feature Consultar
- [] Tratamento de exceções
- [] Validação de dados

<br />

<h2 id="requisicoes">💻 Pré-requisitos</h2>

Antes de começar, verifique se você atendeu aos seguintes requisitos:

* JDK 8 (qualquer versão atual)
* Eclipse
* Mysql
## Executando o projeto

```
1. Crie uma pasta chamada workspace-jframe
2. clone o projeto: git clone https://github.com/Gabriel-developer-01/jframe-cadastro-usuario.git
2. Importe o projeto;
3. execute a classe UsuarioView: src > view > UsuarioView.java
```

<h2 id="config">⚓ Configuração</h2>
 
1. <a href="https://www.youtube.com/watch?v=fmerTu7dWk8" target="_blank" title="acessar o vídeo"><strong>Instalação e configuração do mysql</strong></a>
2. Ir até a classe "ConexaoDAO": src > bd > ConexaoDAO.java
3. trocar a variável url colocando seu usuario e senha do mysql, no meu caso eu fiz o banco de dados no usuario root, então vc deve colocar o usuario e a senha do mysql nos lugares adequados.

Exemplo:

<h1 style="padding: 100px; background: #333333;">
    <img alt="example-config-url" src="https://github.com/Gabriel-developer-01/jframe-cadastro-usuario/blob/main/img/config-url-example.png" width=480px/>
</h1>

> script para criação do banco de dados e tabela.

> caso deseje mudar o nome do banco e tabelas tem que seguir os seguintes passos:
1. Alterar a url para o novo nome do banco de dados: jdbc:mysql://localhost:3306/[nome do banco de dados]?user=[nome do usuario do mysql]&password=[aqui a senha]
2. Nas classes do pacote DAO do projeto terá que mudar nas querys os nomes da tabela antiga(usuario) para o novo nome da tabela.

```
create database faculdade;

CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `tipo_logradouro` varchar(10) DEFAULT NULL,
  `logradouro` varchar(50) DEFAULT NULL,
  `numero` int DEFAULT NULL,
  `telefone_residencial` varchar(15) DEFAULT NULL,
  `telefone_comercial` varchar(15) DEFAULT NULL,
  `telefone_celular` varchar(15) DEFAULT NULL,
  `cpf` varchar(30) NOT NULL,
  `rg` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```

## 🤝 Perfil do dev

<table>
  <tr>
    <td align="center">
      <a href="https://www.linkedin.com/in/gabriel-mendes-3a668917b/">
        <img style="border-radius: 8px" src="https://avatars.githubusercontent.com/Gabriel-developer-01" width="100px;" alt="Gabriel Mendes"/><br>
        <sub>
          <b>Gabriel Mendes</b>
        </sub>
      </a>
    </td>
  </tr>
</table>

[⬆ Voltar ao topo](#nome-do-projeto)
