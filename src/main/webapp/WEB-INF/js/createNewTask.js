/**
 * Created by User on 30.08.2017.
 */

$(document).ready(function() {
    $('#type_of_task').change(function(event, ui) {
        if ($(this).val() == 'dated') {
            $('#dated_task').removeAttr('hidden');
            $('#result').prop('disabled', false);
        } else {
            $('#dated_task').attr("hidden", "hidden");
            $('#result').prop('disabled', true);
        }

        if ($(this).val() == 'periodic') {
            $('#periodic_task').removeAttr('hidden');
            $('.day_of_week').prop('disabled', false);
        } else {
            $('#periodic_task').attr("hidden", "hidden");
            $('.day_of_week').prop('disabled', true);
        }

        if ($(this).val() == 'everyday') {
            $('#everyday_task').removeAttr('hidden');
            $('#everyday').prop('disabled', false);
        } else {
            $('#everyday_task').attr("hidden", "hidden");
            $('#everyday').prop('disabled', true);
        }
    });
});
