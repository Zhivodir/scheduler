$(".choise_check.choise_purpose").click(function(event){
    //
     var checked = $(this)[0].getElementsByTagName('input')[0].getAttribute('value');
     var rows = $(this).find("tr");
     var row = $(this).closest("tr");
     var index = row.parent().children("tr").index(row);

     var res = $.ajax({
         url: "/ajax/load_embedded_tasks",
         data: {id: checked},
         dataType: "json",
         type: "POST",
         success: function(data){
             var breakOut = false;
             if(row.hasClass("isLoaded")){
                 var next = row.next();
                 while(!next.hasClass("choise_purpose")){
                     currentRow = next;
                     next = next.next();
                     currentRow.toggle();
                 }
             } else {
                 var tasks = data;
                 var html;
                 row.addClass("isLoaded");
                 for(var i=0; i < tasks.length; i++) {
                     html += "<tr><td></td><td></td><td>" + tasks[i].description + "</td><td></td></tr>"
                 }
                 row.after(html);
             }
    }});
});

