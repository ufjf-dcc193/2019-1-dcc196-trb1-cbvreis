<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Criar Sede</title>
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Gerenciamento de ONG's</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="index.html">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Ver Sedes</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Ferramentas
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="#">Ferramentas Sede</a>
                        <a class="dropdown-item" href="#">Ferramentas Atividade</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Ferramentas Membros</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#"> Data Atual</a>
                </li>
            </ul>

        </div>
    </nav>



    <h1>Criar sede</h1>


    <form method="POST" action = "/sedes/editar">
        <div class="form-group">
            <label for="nome_fantasia">Nome Fantasia</label>
            <input id="id" name="id" type="hidden" value="${sede.id}"/> 
            <input type="text" name="nome_fantasia" value="${sede.nome_fantasia}" class="form-control" id="nome_fantasia" aria-describedby="emailHelp"
                placeholder="Digite um Nome">
        </div>

        <div class="form-group">
            <label for="estado">Estado Federação</label>
            <input type="text" name="estado_federacao" value="${sede.estado_federacao}" class="form-control" id="estado_federacao" aria-describedby="emailHelp"
                placeholder="Digite um estado">
        </div>

        <div class="form-group">
            <label for="email">Cidade</label>
            <input type="text" name="cidade" class="form-control" value="${sede.cidade}" id="cidade" aria-describedby="emailHelp"
                placeholder="Digite a cidade">
        </div>
        <div class="form-group">
            <label for="email">Bairro</label>
            <input type="text" name="bairro" class="form-control" id="bairro" value="${sede.bairro}" aria-describedby="emailHelp"
                placeholder="Digite o Bairro">
        </div>

        <div class="form-group">
            <label for="email">Telefone de Contato</label>
            <input type="text" name="telefone" class="form-control" id="telefone" value="${sede.telefone}" aria-describedby="emailHelp"
                placeholder="Telefone de Contato">
        </div>
        <div class="form-group">
            <label for="email">Endereço Web</label>
            <input type="text" name="web" class="form-control" id="web" value="${sede.web}"aria-describedby="emailHelp"
                placeholder="Digite um site web">
        </div>
        <button type="submit" class="btn btn-primary">Criar uma Sede</button>
    </form>


    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>

</html>