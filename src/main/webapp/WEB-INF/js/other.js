/**
 * Created by User on 06.09.2017.
 */

onload = function() {
    tree("tree", "/ajax/load_tree_of_purposes_and_tasks");
}

document.oncontextmenu = function (){return false};

var tr = $('#myTable .choise_check'),
    selection = {
        single: function(el) {
            $(el).removeClass(this.purpose);
            tr.not(el).addClass(this.purpose);
            tr.not(el).removeClass(this.cl);
            this.ctrl(el);
        },
        shift: function(el) {
            if (typeof this.last !== 'number') {
                return this.single(el);
            }
            var till = $(el).index(this.slcr),
                from = this.last;
            if (from > till) till = [from, from = till][0];
            tr.not(tr.eq(this.last)).removeClass(this.cl);
            tr.not(tr.eq(this.last)).addClass(this.purpose);
            tr.slice(from, till).add(el).addClass(this.cl);
            tr.slice(from, till).add(el).removeClass(this.purpose);
        },
        ctrl: function(el) {
            if($(el).hasClass('selected')){
                $(el).removeClass(this.cl);
                $(el).addClass(this.purpose);
            }else{
                $(el).addClass(this.cl);
                $(el).removeClass(this.purpose);
            }
            this.last = $(el).index(this.slcr);
            console.log(this.last);
        },
        slcr: '#myTable .choise_check',
        cl: 'selected',
        purpose: 'active',
        last: null
    };


tr.on('click', function(e) {
    method = !e.shiftKey && !e.ctrlKey ? 'single' : (e.shiftKey ? 'shift' : 'ctrl');
    selection[method](this);
    $('#myTable tr').each(function(indx, el) {
        $("input:checkbox").removeAttr("checked");
    })
    $('#myTable tr.selected').each(function(indx, el) {
        var inp = $("input:checkbox", el)[0];
        event.target != inp && (inp.checked = !inp.checked)
    })
});


