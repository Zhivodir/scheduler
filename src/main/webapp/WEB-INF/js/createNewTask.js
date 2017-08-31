/**
 * Created by User on 30.08.2017.
 */

$(document).ready(function() {
    $('#type_of_task').change(function(event, ui) {
        if ($(this).val() == 'dated') {
            $('#dated_task').removeAttr('hidden');
        } else {
            $('#dated_task').attr("hidden", "hidden");
        }

        if ($(this).val() == 'periodic') {
            $('#periodic_task').removeAttr('hidden');
        } else {
            $('#periodic_task').attr("hidden", "hidden");
        }

        if ($(this).val() == 'everyday') {
            $('#everyday_task').removeAttr('hidden');
        } else {
            $('#everyday_task').attr("hidden", "hidden");
        }
    });

});
