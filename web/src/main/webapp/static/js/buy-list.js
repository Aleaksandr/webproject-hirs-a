$(document).ready(function () {

    //autocomplete
    $.ajax({
        url : "/buys/autocomplete",
        type: 'GET',
        contentType: 'application/json',
        data : null,
        success: function (data) {
            $( "#autocomplete" ).autocomplete( "option", "source", data);
        }
    });
    $( "#autocomplete" ).autocomplete({
        minLength: 1,
        select: function( event, ui ) {
            console.log("select!!!");
        }

    });

    //Delete by trash icon
    $('.fa-trash-o').on('click', function(event) {
        event.preventDefault();
        var targA = $(event.target);
        var link = targA.attr("href");
        if (link) {
            $.ajax({
                url : link,
                type: 'DELETE',
                contentType: 'text/html',
                mimeType: 'text/html',
                data : null,
                success: function (data) {
                    targA.closest("tr").remove();
                }
            });
        }
    });

    //Spinner
    $(document).ajaxStart(function(){
        $('#loading').show();
    }).ajaxStop(function(){
        setTimeout( function(){
            $('#loading').hide();
        }, 300);
    });
})