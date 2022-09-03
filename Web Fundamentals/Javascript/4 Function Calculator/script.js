let result = document.getElementById("display");

let press =(number)=>{
    result.value = result.value + number ;
}

let calculate =()=>{
    try{
        result.value = eval(result.value)
    }
    catch(err){
        alert("NUN")

    }
}

function clr(){
    result.value = "";
}



