// for bootstrap
import 'bootstrap/dist/css/bootstrap.css'
import 'open-iconic/font/css/open-iconic-bootstrap.css';
import $ from 'jquery';
// for common css
import '../../css/style.css';

/**
 * Disable multi submit.
 */
$(document).ready(function () {
    $("form").submit(function () {
        $(":submit", this).prop("disabled", true);
    });
});
