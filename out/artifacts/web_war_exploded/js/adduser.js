function validate() {
    var username = document.getElementById("username");
    if (username.value == "") {
        username.style.backgroundColor = "red";
        document.getElementById("username").placeholder = "Add your username";
        username.style.color = "snow";
        return false;
    }
    else {
        username.style.backgroundColor = "green";
        username.style.color = "snow";
    }
}
function test() {
    var dataWait;
    $.ajax({
        type: "GET",
        url: "/getAllUser",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data) {
            dataWait = data;
        },
        failure: function (errMsg) {
            alert(errMsg);
        }
    });
        if (validate() == false)
            return;
        var username = document.getElementById("username");
        var parmeters = '{"uid":' + dataWait
        ',"username":"' + username + '"}';
        $.ajax({
            type: "POST",
            url: "/addUser",
            data: parameters,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data) {
                window.location.href = "succes.html";
            },
            failure: function (errMsg) {
                alert(errMsg);
            }
        });
}
