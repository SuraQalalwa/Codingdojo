// elemant = document.querySelectorAll(".color1")
// for(var i=0;i<{{times}};i++){
//     // var elemant = document.createElement('div');
//     document.body.appendChild(elemant);
// }

// elemant = document.querySelectorAll(".color2")
for(var x=0;x<{{times}};x++){
    var elemant = document.createElement('tr');
    document.body.appendChild(elemant);
}

for(var y=0;y<{{number}};y++){
    var elemant = document.createElement('td');
    document.body.appendChild(elemant);
  }