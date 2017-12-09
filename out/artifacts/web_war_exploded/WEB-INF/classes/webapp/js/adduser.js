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
    if (validate() == false)
        return;
    $.ajax({
        type: "GET",
        url: "getNextUserId",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data) {
            dataWait = data;
            var username = document.getElementById("username").value;
            alert(username + " was added to WeatherNow");
            var parameters = '{"uid":' + dataWait +
                ',"username":"' + username + '"}';
            $.ajax({
                type: "POST",
                url: "addUser",
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
        },
        failure: function (errMsg) {
            alert(errMsg);
        }
    });
}
