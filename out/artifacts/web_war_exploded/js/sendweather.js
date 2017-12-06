var nameId;
var townId;

function validate() {
    var username = document.getElementById("username");
    var town = document.getElementById("town");
    var category = document.getElementsByName("category");
    var temperature = document.getElementById("temperature");
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
    if (town.value == "") {
        town.style.backgroundColor = "red";
        document.getElementById("town").placeholder = "Add the perception's town";
        town.style.color = "snow";
        return false;
    }
    else {
        town.style.backgroundColor = "green";
        town.style.color = "snow";
    }
    if (category.value == "") {
        alert("Category is needed")
        return false;
    }
    if (temperature.value == "") {
        temperature.style.backgroundColor = "red";
        document.getElementById("temperature").placeholder = "Temperature is needed";
        category.style.color = "snow";
        return false;
    }
    else {
        temperature.style.backgroundColor = "green";
        temperature.style.color = "snow";
    }
}


function send() {
    if (validate() == false)
        return;
    var dataWait;
    $.ajax({
        url: "/wnTeszt/getTownIdByName/" + username.value,
        contentType: 'application/json',
        success: function (data, textStatus, xhr) {
            console.log(xhr.status);
            console.log(data);
            townId = data;
            alert(townId);
        },
        failure:function () {
            console.log("fail");
        },
        error:function () {
            console.log("error");
        }
    });
    $.ajax({
        url: "/wnTeszt/getUserIdByName/" + town.value,
        contentType: 'application/json',
        success: function (data, textStatus, xhr) {
            console.log(xhr.status);
            console.log(data);
            nameId = data;
        },
        failure:function () {
            console.log("fail");
        },
        error:function () {
            console.log("error");
        }
    });
    $.ajax({
        type: "GET",
        url: "/wnTeszt/getNextWeatherId",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data) {
            dataWait = data;
            var username = document.getElementById("username").value;
            var town = document.getElementById("town").value;
            var category = document.getElementsByName("category").value;
            var temperature = document.getElementById("temperature").value;
            var parameters = '{' +
                '"wid":' + dataWait + ',' +
                '"uid":' + nameId + ',' +
                '"username":"' + username + '",' +
                '"tid":' + townId + ',' +
                '"town":"' + town + '",' +
                '"category":"' + category + '"' +
                '"temperature":' + temperature +
            '}';
            $.ajax({
                type: "POST",
                url: "/wnTeszt/addWeather",
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