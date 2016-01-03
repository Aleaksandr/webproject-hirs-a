$(document).ready(function () {

    //Spinner
    $(document).ajaxStart(function(){
        $('#loading').show();
    }).ajaxStop(function(){
        setTimeout( function(){
            $('#loading').hide();
        }, 300);
    });
})

//Update buy
function updateBuy() {
    var form = $("#form_buy");
    form.find('input[name="_method"]').val('PUT');
    form.submit();
}

//Delete buy
function delBuy() {
    var form = $("#form_buy");
    form.find('input[name="_method"]').val('DELETE');
    form.submit();
}

//Save Buy
function saveBuy() {
    var form = $("#form_buy");
    form.find('input[name="_method"]').val('POST');
    form.submit();
}

//Get buy
function getBuy() {
    var form = $("#form_buy");
    form.find('input[name="_method"]').val('GET');
    form.submit();
}