var response;
$.ajax({
    type: "GET",
    url: "/getAllWeather",
    contentType: "application/json; charset=utf-8",
    dataType: "json",
    success: function(data){response = data;},
    failure: function(errMsg) {
        alert(errMsg);
    }
});
$(function() {
    $.each(response, function(i, item) {
        var $tr = $('<tr>').append(
            $('<td>').text(item.id),
            $('<td>').text(item.uid),
            $('<td>').text(item.username),
            $('<td>').text(item.tid),
            $('<td>').text(item.town),
            $('<td>').text(item.category),
            $('<td>').text(item.temperature)
        ).appendTo('#perceptions');
        console.log($tr.wrap('<p>').html());
    });
});