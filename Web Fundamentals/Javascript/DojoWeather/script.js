/// Remove cookie
var element = document.querySelector("#cookie");
function dojo(){
    element.remove();
}

//temperatureConverter

function celtofr(temp){
    return Math.round(1.8 * temp + 32);
}
function frtocel(temp) {
    return Math.round( (temp - 32)/1.8);
}
function tempConverter(element) {
    for(var i=1; i<9; i++) {
        var tempSpan = document.querySelector("#temp" + i);
        var tempValue = parseInt(tempSpan.innerText);
        if(element.value == "°C") {
            tempSpan.innerText = frtocel(tempValue);
        } else {
            tempSpan.innerText = celtofr(tempValue);
        }
    }
}