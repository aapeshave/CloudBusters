$(document).ready(function () {

    $('#submit_blog_create').on('click', function () {

        $("#blogform").submit(function (event) {
            alert("Handler for .submit() called.");
            $.ajax({
                type: "POST",
            url: "/blog",
            data: $("#blogform").serialize(),
                success: function(data) {
                    $('#created').html(response);
                alert(data);
            }
        });
            event.preventDefault();
        });
        $('#blogform').submit();
    });


});