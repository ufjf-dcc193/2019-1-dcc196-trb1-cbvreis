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

    <title>Criar Atividade</title>
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
                            <a class="nav-link" href="/../sedes">Ver Sedes</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Ferramentas
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="/../sedes">Ferramentas Sede</a>
                                <a class="dropdown-item" href="/../atividades/relatorios">Relatórios</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="/../membros">Ferramentas Membros</a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled" href="#"> Data Atual</a>
                        </li>
                    </ul>
        
                </div>
            </nav>
        
    <div class="container">
        <h1>Nome:${sede.nome_fantasia}</h1>
        <h3>WebSite:${sede.web}</h3>
        nome completo, função, e-mail de contato, data de entrada e de saída da função

        <hr />
        <form method="POST" action="criar-atividade">
            <input name="sedeAtividade" type="hidden" id="${sede.id}" value="${sede.id}" />
            <div class="form-group">
                <label for="tituloAtividade">Título da atividade</label>
                <input type="text" class="form-control" name="titulo" id="tituloAtividade"
                    placeholder="Digite o título da atividade" required>
            </div>
            <div class="form-group">
                <label for="textoAtividade">Texto de descrição</label> <br />
                <textarea class="form-control" name="descricao">Descreva a atividade</textarea>
            </div>
            <div class="form-group">
                <label for="categoria">Escolha a categoria</label>
                <select name="categoria" class="form-control" id="categoria" required>
                    <option value="Assistencial"> Assistencial </option>
                    <option value="Jurídica"> Jurídica </option>
                    <option value="Financeira"> Financeira </option>
                    <option value="Executiva"> Executiva </option>
                </select>
            </div>
            <div class="form-group">
                <label for="horasDeAtividade">Horas de atividade</label>
                <input type="number" class="form-control" name="horasDeAtividade" id="horasDeAtividade"
                    placeholder="Horas de atividade" required>
            </div>
            <div class="form-group">
                <label for="dataDeInicio">Data de entrada</label>
                <input type="date" class="form-control" name="dataDeInicio" id="dataDeInicio"
                    placeholder="Digite a data de início" required>
            </div>
            <div class="form-group">
                <label for="dataDeFim">Data de saída</label>
                <input type="date" class="form-control" name="dataDeFim" id="dataDeFim"
                    placeholder="Digite a data de fim" required>
            </div>
            <button type="submit" class="btn btn-primary">Cadastrar</button>
        </form>
    </div>

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