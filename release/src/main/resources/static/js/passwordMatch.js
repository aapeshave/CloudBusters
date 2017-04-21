/**
 * Created by ameyutturkar on 4/15/17.
 */
alert("Javascript for password match called from external JS file");
$(document).ready(function () {
    $('#signup-form').validate({
        // rules
        rules: {
            inputPassword: {
                required: true,
                minlength: 8
            },
            retypeInputPassword: {
                required: true,
                minlength: 8,
                passwordMatch: true // set this on the field you're trying to match
            }
        },

        // messages
        messages: {
            inputPassword: {
                required: "What is your password?",
                minlength: "Your password must contain more than 7 characters"
            },
            retypeInputPassword: {
                required: "You must confirm your password",
                minlength: "Your password must contain more than 7 characters",
                passwordMatch: "Your Passwords Does Not Match" // custom message for mismatched passwords
            }
        }
    });//end validate
});