/**
 * Created by ameyutturkar on 4/15/17.
 */
const BEARER_TOKEN = "eyJraWQiOiJOUGYxRDJxMGhFNWtDU1A1a0pWZDZhZWpZU3hDSGM3MzVFTGVnOW9MWUYwPSIsImFsZyI6IlJTMjU2In0.eyJjdXN0b206Y3VzdG9tZXJfaWQiOiJmYWtlIiwiY3VzdG9tOnNvY19pZCI6ImZha2UiLCJzdWIiOiI4ZTMyOGEyYy0wMzBiLTQyNDAtOTdiMi03NWUzODE3M2FlYTAiLCJjb2duaXRvOmdyb3VwcyI6WyJBZG1pbiJdLCJpc3MiOiJodHRwczpcL1wvY29nbml0by1pZHAudXMtd2VzdC0yLmFtYXpvbmF3cy5jb21cL3VzLXdlc3QtMl9EMU9zbjlmZ2YiLCJjb2duaXRvOnVzZXJuYW1lIjoiOGUzMjhhMmMtMDMwYi00MjQwLTk3YjItNzVlMzgxNzNhZWEwIiwiYXVkIjoiNDJnZWt0ZHF2OGs0NXVlNWlmbDNoM2xoNG8iLCJldmVudF9pZCI6Ijc1NTBhYWU5LWEwYTktNGRhNy1iZTFjLThlNTIzMjFhOWZhOCIsInRva2VuX3VzZSI6ImlkIiwiYXV0aF90aW1lIjoxNTYxNjcyOTQyLCJleHAiOjE1NjE2NzY1NDIsImlhdCI6MTU2MTY3Mjk0MiwiZW1haWwiOiJjZW50cmFsLWRldkBkYXJrYnl0ZXMuY29tIn0.FQZ-axnSHiLO2TrcOEfm4iM8mGDULpm6---S7ONzvYWnmTLnkx37TwzlGALbJNbPXiyZ1tTt16E-1A9Nxe2YqYn4g3ltaBNPwfgy5JRqfQirZXVMJBny-PlHdsiaiOivu60q831cP-GvyaJlAmAG30ujIcPlOMtmiAhnsv3VembKhi-uMPjXcdODOm-u8Fy2uNzz_v2PXx2u1D6xu5x8lR750b_kI9zCr8sH07YBTAJCw9jQXh084QwELsklTiAdwMRpyDdbz7l8L-VeBJMytcyDhc40JQtWZZRc7QqeAFJ7wM75oVr4loZ2QA7OZTYtqRjlXAcrgzneL8syPiEJwA";
const URL = "https://p0.d.hmr.sophos.com/api/sessions";
function callJS() {
}

function logInToCentral() {
}

$(document).ready(function () {
    let data = {
        token: BEARER_TOKEN,
        tenantId: 'bd02cf24-8f2d-4432-97a7-4ca209ea6b66'
    };
    let headers = {
        "Access-Control-Allow-Headers": "*",
        "Access-Control-Allow-Origin": "*",
        "Access-Control-Allow-Methods": "POST"
    };

    $('#sign-in-to-central').on('click', function () {
        $.ajax({
            type: "POST",
            url: URL,
            crossOrigin: true,
            data: data,
            success: onSuccess(),
            dataType: JSON,
            error: onError()
        });

        function onSuccess(data) {
            console.log(data);
        }

        function onError(data) {
            console.log("error: " + data);
        }
    });

});
