 function mascara(t, mask){
    var i = t.value.length;
    var saida = mask.substring(1,0);
    var texto = mask.substring(i)
    if (texto.substring(0,1) != saida){
        t.value += texto.substring(0,1);
    }
}

$(".DigitOnly").keypress(function (e) {
     //if the letter is not digit then display error and don't type anything
    //alert("aaa");
    var key = e.which;
     if (key != 8 && key != 0 && (key < 48 || key > 57)) {
        //display error message
        //$("#errmsg").html("Digits Only").show().fadeOut("slow");
               return false;
    }
});