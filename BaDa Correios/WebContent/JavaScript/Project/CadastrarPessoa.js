

    //$('#CidadeId').prop("disabled", true);


    var ajaxCidadeId = function() {
        var Estado = $('#EstadoId').val();
        if (Estado != "") {

            $.get('CadastrarPessoasGetCidades', { EstadoId: Estado }, function(responseText) {
                $('#CidadeId').html(responseText);
                if (Estado != "0") {
                    $('#CidadeId').prop("disabled", false);
                } else {
                    $('#CidadeId').prop("disabled", true);
                }
            });
        }
    }

    $("#EstadoId").change(ajaxCidadeId.apply());


