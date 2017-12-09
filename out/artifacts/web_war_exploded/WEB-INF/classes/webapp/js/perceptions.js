function buildHtmlTable(selector, myList) {
    var columns = addAllColumnHeaders(myList, selector);

    for (var i = 0; i < myList.length; i++) {
        var row$ = $('<tr/>');
        for (var colIndex = 0; colIndex < columns.length; colIndex++) {
            var cellValue = myList[i][columns[colIndex]];
            if (cellValue == myList[i]["temperature"]) cellValue = myList[i]["temperature"] + " °C";
            if (cellValue == myList[i]["user"]) cellValue = myList[i]["user"]["name"];
            if (cellValue == myList[i]["town"]) cellValue = myList[i]["town"]["name"];
            if (cellValue == null) cellValue = "";
            row$.append($('<td/>').html(cellValue));
        }
        $(selector).append(row$);
    }
}

function addAllColumnHeaders(myList, selector) {
    var columnSet = [];
    var headerTr$ = $('<tr/>');

    for (var i = 0; i < myList.length; i++) {
        var rowHash = myList[i];
        for (var key in rowHash) {
            if ($.inArray(key, columnSet) == -1) {
                columnSet.push(key);
                headerTr$.append($('<th/>').html(key));
            }
        }
    }
    $(selector).append(headerTr$);

    return columnSet;
}

function loadWeather() {
    var urlPath = "getAllWeather";
    $.ajax({
        url: urlPath,
        contentType: 'application/json',
        success: function (data, textStatus, xhr) {
            console.log(xhr.status);
            console.log(data);
            var resultTarget = $('#perceptions')
            resultTarget.html("");
            buildHtmlTable(resultTarget, data);
            addAllColumnHeaders(data, selector);
        },
        failure:function () {
            console.log("fail");
        },
        error:function () {
            console.log("error");
        }
    });
}

$(document).ready(
    function () {
        console.log("ready");
        loadWeather();
    }
)