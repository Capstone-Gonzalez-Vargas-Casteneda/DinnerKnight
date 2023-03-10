"USE STRICT";


    function requestFood(){
        $.ajax({
            method: 'GET',
            url: 'www.themealdb.com/api/json/v1/1/search.php?s=Arrabiata'
        }).done(function (data) {
            console.log(data);

        });

}

