function loadWeather() {
    var json;
    var urlPath = "getAllWeather";
    $.ajax({
        url: urlPath,
        contentType: 'application/json',
        success: function (data, textStatus, xhr) {
            console.log(xhr.status);
            console.log(data);
            json = data;
            console.log(json.temperature);
        },
        failure:function () {
            console.log("fail");
        },
        error:function () {
            console.log("error");
        }
    });
}