$(document).ready(function() {
   // $("#ValorOutput").prop("disabled", true);
   // $("#cadastrarButton").prop("disabled", true);

    var gerarValor = function(e) {
        var peso = $("#PesoInput").val();

        var largura = parseInt($("#LarguraInput").val());
        var altura = parseInt($("#AlturaInput").val());
        var profundidade = parseInt($("#ProfundidadeInput").val());
        var soma = largura + altura + profundidade;

        var valor = 50;
        
        if (soma > 100) {
            valor += (Math.abs(parseInt((soma-100) / 100))+1) * 5;
        }        
        if (peso > 300) {
            valor += (parseInt(Math.abs(peso-300) / 100)+1) * 5;
        }

        $("#ValorOutput").val(valor);
    }

    $("#gerarValor").on('click', gerarValor);

    $("#cadastrarButton").on('click', function(e) {
        gerarValor.apply();
    });
    
});