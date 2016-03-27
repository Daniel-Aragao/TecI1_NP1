$(document).ready(function() {
	
    $('#confirmButton').prop("disabled", true);

    $('#CidadeId').prop( "disabled", true );    
	
	$( "#EstadoId" ).change(function(event) {
		var Estado=$('#EstadoId').val();
			$.get('CadastrarPessoasGetCidades',{EstadoId:Estado},function(responseText) { 
				$('#CidadeId').html(responseText);         
				if(Estado != "0"){
					$('#CidadeId').prop( "disabled", false );
				}else{
					$('#CidadeId').prop( "disabled", true );
				}
			});			
    });

    $( "#CidadeId" ).change(function(event) {
		var Cidade=$('#CidadeId').val();
			     
        if(Cidade != "0"){
            $('#confirmButton').prop( "disabled", false );
        }else{
            $('#confirmButton').prop( "disabled", true );
        }	
	});    
	
});