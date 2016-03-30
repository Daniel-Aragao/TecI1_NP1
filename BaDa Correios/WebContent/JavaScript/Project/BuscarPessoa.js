function confirmar(nome, id){
    var decisao = confirm("tem certeza que deseja excluir '" + nome + "'?");
    if (decisao) {
        window.location = "ExcluirPessoa?PessoaId=" + id;           
    }
}