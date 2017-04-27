/**
 * Created by ajinkya on 4/26/17.
 */

$('document').ready(function () {
    'use strict';

    $('#submit_blog_create').on('click', function () {

        $("#blogform").submit(function (event) {
            alert("Handler for .submit() called.");
            $.ajax({
                type: "POST",
                url: "/blog",
                data: $("#blogform").serialize(),
                success: function (data) {
                    alert(data);
                }
            });
            event.preventDefault();
        });
        $('#blogform').submit();
    });

});