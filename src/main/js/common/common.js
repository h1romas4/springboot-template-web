import $ from 'jquery';

/**
 * Disable multi submit.
 */
$(document).ready(function () {
    $("form").submit(function () {
        $(":submit", this).prop("disabled", true);
    });
});
