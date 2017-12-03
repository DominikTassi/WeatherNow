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
    else{
        username.style.backgroundColor = "green";
        username.style.color = "snow";
    }
    if (town.value == "") {
        town.style.backgroundColor = "red";
        document.getElementById("town").placeholder = "Add the perception's town";
        town.style.color = "snow";
        return false;
    }
    else{
        town.style.backgroundColor = "green";
        town.style.color = "snow";
    }
    if (category.value == "") {
        category.style.backgroundColor = "red";
        document.getElementById("category").placeholder = "Category is needed";
        category.style.color = "snow";
        return false;
    }
    else{
        category.style.backgroundColor = "green";
        category.style.color = "snow";
    }
    if (temperature.value == "") {
        temperature.style.backgroundColor = "red";
        document.getElementById("temperature").placeholder = "Temperature is needed";
        category.style.color = "snow";
        return false;
    }
    else{
        temperature.style.backgroundColor = "green";
        temperature.style.color = "snow";
    }
    $(document).ready(function () {
        var dataWait;
        $.ajax({
            type: "GET",
            url: "/getAllWeather",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function(data){dataWait = data;},
            failure: function(errMsg) {
                alert(errMsg);
            }
        });
        $("#submit").click(function(){
            if(validate() == false)
                return;
            var username = document.getElementById("username");
            var town = document.getElementById("town");
            var category = document.getElementsByName("category");
            var temperature = document.getElementById("temperature");
            var parameters = '{' +
                '"id":'+dataWait+',' +
                '"uid":' + TODO +',' +
                '"username":"' +username +'",' +
                '"tid":'+TODO + ',' +
                '"town":"'+town+'"' +
                '"category":"'+category+'"'+
                '"temperature":'+temperature
                '}';
            $.ajax({
                type: "POST",
                url: "/addWeather",
                data: parameters,
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function(data){window.location.href = "succes.html";},
                failure: function(errMsg) {
                    alert(errMsg);
                }
            });
        });
    });
}
