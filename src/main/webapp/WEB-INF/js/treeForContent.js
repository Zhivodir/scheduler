$(".choise_check.choise_purpose").click(function(event){
     var checked = $(this)[0].getElementsByTagName('input')[0].getAttribute('value');
    $.ajax({
        url: "/ajax/load_embedded_tasks",
        data: {id: checked},
        dataType: "json",
        type: "POST",
        success: function(result){
           alert("SUCCESS");
    }});
});