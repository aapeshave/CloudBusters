$(document).ready(function () {

    $('#submit_blog_create').on('click', function () {

        $("#blogform").submit(function (event) {
            $.ajax({
                type: "POST",
            url: "/blog",
            data: $("#blogform").serialize(),
                success: function(data) {
                    $('#created').html(data);
            }
        });
            event.preventDefault();
        });
        $('#blogform').submit();
    });

});