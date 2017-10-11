$(".choise_check.choise_purpose").click(function(event){
     var checked = $(this)[0].getElementsByTagName('input')[0].getAttribute('value');
     var res = $.ajax({
         url: "/ajax/load_embedded_tasks",
         data: {id: checked},
         dataType: "json",
         type: "POST",
         success: function(data){
             alert("SUCCESS");
             var tasks = data;
             for(var i=0; i < tasks.length; i++) {
                 var tr = document.createElement('TR');
                 tr.id = tasks[i].id;
                 tr.className = "choise_task";

                 tr.innerHTML = '<td></td>'
                 tr.innerHTML = '<td></td>'
                 tr.innerHTML = '<td>tasks[i].description</td>'
                 tr.innerHTML = '<td></td>'
                 node.getElementsByTagName('TR')[0].appendChild(td)
             }
    }});
});

