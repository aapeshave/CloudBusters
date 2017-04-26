$(document).ready(function () {


    $("button").click(function () {
        alert("hey");
        $("form").submit(function () {
            alert("Submitted");
        });
        $("form").submit();
    });
});