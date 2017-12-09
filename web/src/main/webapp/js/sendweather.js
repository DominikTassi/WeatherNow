function validate() {
    var username = document.getElementById("username");
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
        type: "GET",
        url: "getNextWeatherId",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data) {
            var dataWait = data;
            var username = document.getElementById("username").value;
            var town = document.getElementById("town").value;
            getIds(dataWait,username,town);
        },
        failure: function (errMsg) {
            alert(errMsg);
        }
    });
}

function getIds(weatherId,username,town) {
    var userid;
    var townid;
    $.ajax({
        url: "getUserIdByName/" + username,
        contentType: 'application/json',
        success: function (data, textStatus, xhr) {
            console.log(xhr.status);
            console.log(data);
            userid = data;
            $.ajax({
                url: "getTownIdByName/" + town,
                contentType: 'application/json',
                success: function (data, textStatus, xhr) {
                    console.log(xhr.status);
                    console.log(data);
                    townid = data;
                    add(weatherId,userid,townid);
                },
                failure:function () {
                    console.log("fail");
                },
                error:function () {
                    console.log("error");
                }
            });
        },
        failure:function () {
            console.log("fail");
        },
        error:function () {
            console.log("error");
        }
    });
}

function add(weatherid, userid, townid) {
    var category = document.getElementById("category").value;
    var temperature = document.getElementById("temperature").value;
    var username = document.getElementById("username").value;
    var town = document.getElementById("town").value;
    var parameters = '{' +
        '"wid":' + weatherid + ',' +
        '"uid":' + userid + ',' +
        '"username":"' + username + '",' +
        '"tid":' + townid + ',' +
        '"town":"' + town + '",' +
        '"category":"' + category + '",' +
        '"temperature":' + temperature +
        '}';
    $.ajax({
        type: "POST",
        url: "addWeather",
        data: parameters,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data) {
            window.location.href = "succes.html";
            alert("Your perception has been added to WeatherNow!")
        },
        failure: function (errMsg) {
            alert(errMsg);
        }
    });
}



$.ajax({
    url:'getAllTown',
    type:'GET',
    contentType: "application/json; charset=utf-8",
    dataType: 'json',
    success: function( json ) {
        $.each(json, function(i, value) {
            $('#town').append($('<option>').text(json[i]["name"]).attr('value', json[i]["name"]));
        });
    }
});

