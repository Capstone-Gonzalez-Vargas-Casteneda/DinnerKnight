"USE STRICT";


    function requestFood(){
fetch("https://themealdb.com/api/json/v1/1/search.php?s=pasta").then(resp => resp.json()).then(data => console.log(data))
}
requestFood();

