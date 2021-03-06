/**
 * Created by User on 15.05.2017.
 */


function tree(id, url) {
    var element = document.getElementById(id);

    function hasClass(elem, className) {
        return new RegExp("(^|\\s)"+className+"(\\s|$)").test(elem.className)
    }

    function toggleNode(node) {
        // определить новый класс для узла
        var newClass = hasClass(node, 'ExpandOpen') ? 'ExpandClosed' : 'ExpandOpen'
        // заменить текущий класс на newClass
        // регексп находит отдельно стоящий open|close и меняет на newClass
        var re =  /(^|\s)(ExpandOpen|ExpandClosed)(\s|$)/
        node.className = node.className.replace(re, '$1'+newClass+'$3')
    }

    function load(node) {

        function showLoading(on) {
            var expand = node.getElementsByTagName('DIV')[0]
            expand.className = on ? 'ExpandLoading' : 'Expand'
        }


        function onSuccess(data) {
            if (!data.errcode) {
                onLoaded(data)
                showLoading(false)
            } else {
                showLoading(false)
                onLoadError(data)
            }
        }


        function onAjaxError(xhr, status){
            showLoading(false)
            var errinfo = { errcode: status }
            if (xhr.status != 200) {
                // может быть статус 200, а ошибка
                // из-за некорректного JSON
                errinfo.message = xhr.statusText
            } else {
                errinfo.message = 'Некорректные данные с сервера'
            }
            onLoadError(errinfo)
        }


        function onLoaded(data) {
            var purposes = data
            for(var i=0; i<purposes.length; i++) {
                var li = document.createElement('LI')
                li.id = purposes[i].id

                li.className = "Node Expand" + 'Closed'
                if (i == data.length-1) li.className += ' IsLast'

                li.innerHTML = '<input class="radio_move_to" type="checkbox" name="move_to" value=' + purposes[i].id + '>'
                li.innerHTML += '<div class="Expand"></div><div class="Content">' + purposes[i].description + '</div>'
                li.innerHTML += '<ul class="Container"  id = ' + purposes[i].id + '></ul>'
                node.getElementsByTagName('UL')[0].appendChild(li)
            }

            node.isLoaded = true
            toggleNode(node)
        }

        function onLoadError(error) {
            var msg = "Ошибка " + error.errcode
            if (error.message) msg = msg + ' :' + error.message
            alert(msg)
        }

        showLoading(true);

        var str = "";
        var str = str + $('input[type=checkbox].choise_folder:checked').map(function() {
            return this.value;
        }).get();

        $.ajax({
            url: url,
            data: {id: node.id},
            dataType: "json",
            success: onSuccess,
            error: onAjaxError,
            cache: false
        })
    }


    element.onclick = function(event) {
        event = event || window.event
        var clickedElem = event.target || event.srcElement

        if (!hasClass(clickedElem, 'Expand')) {
            return // клик не там
        }

        // Node, на который кликнули
        var node = clickedElem.parentNode
        if (hasClass(node, 'ExpandLeaf')) {
            return // клик на листе
        }

        if (node.isLoaded || node.getElementsByTagName('LI').length) {
            // Узел уже загружен через AJAX(возможно он пуст)
            toggleNode(node)
            return
        }

        if (node.getElementsByTagName('LI').length) {
            // Узел не был загружен при помощи AJAX, но у него почему-то есть потомки
            // Например, эти узлы были в DOM дерева до вызова tree()
            // Как правило, это "структурные" узлы
            // ничего подгружать не надо
            toggleNode(node)
            return
        }

        // загрузить узел
        load(node)
    }
}
