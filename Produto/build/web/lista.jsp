<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Compras</title>
    </head>
    <body>
        <h1>Novo Produto</h1>
        <form method="POST" action="lista_compras">
            Produto: <input type="text" name="descricao" size="40" /><br/>
            Quantidade: <input type="number" name="quantidade" size="4" /><br/>
            Pre&ccedil;o: <input type="number" name="preco" size="10" /><br/>
            <input type="submit" value="Adicionar" />
        </form>
        <%
          java.util.ArrayList<dados.Produto> 
          lista = (java.util.ArrayList<dados.Produto>) session.getAttribute("lista");
          if(lista == null || lista.isEmpty()){
        %>
        <p>Nao ha produtos cadastrados</p>
        <% } else { %>
        <br>
        <table border="1px">
            <tr>
                <td>Descricao</td>
                <td>Quantidade</td>
                <td>preco</td></tr>
                <% for(dados.Produto prod:lista){ %>
                    <tr>
                        <td><%= prod.getDescricao()%></td>
                        <td><%= prod.getQuantidade()%></td>
                        <td><%= prod.getPreco()%></td>
                    </tr> 
                    <% } %>
        </table>
        <% } %>
    </body>
</html>
