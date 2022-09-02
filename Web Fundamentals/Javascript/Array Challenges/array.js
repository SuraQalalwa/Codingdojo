///////////////*Always Hungry*///////////////

function alwaysHungry(arr) {
    var counter =0;
    for(i=0; i<arr.length;i++){
        if(arr[i]=="food"){
            console.log("yummy");
            counter ++;
        }
    }
    if (counter == 0) {
        console.log("I'm Hungry");
    }
}
alwaysHungry([3.14, "food", "pie", true, "food"]);
alwaysHungry([4, 1, 5, 7, 2]);



//////////////*High Pass Filter*/////////////////////

function highPass(arr, cutoff) {
    var filteredArr = [];
    for( i=0; i<arr.length;i++){
        if(arr[i]>cutoff){
            filteredArr.push(arr[i]);
        }
    }
    return filteredArr;
}
var result = highPass([6, 8, 3, 10, -2, 5, 9,6,12], 5);
console.log(result); 

/////////////////*Better than Average*////////////////////

function betterThanAverage(arr) {
    var sum = 0;
    var avg;
    var count = 0
    for(i=0;i<arr.length;i++){
        sum=sum+arr[i];
    }
    avg=sum/arr.length;
    for(i=0;i<arr.length;i++){
        if(arr[i]>avg){
            count++;
        }
    }
    return count;
}
var result = betterThanAverage([6, 8, 3, 10, -2, 5, 9]);
console.log(result); 

///////////////////*Array Reverse*////////////////
var Array=[]
function reverse(arr) {
    for(i=1;i<=arr.length;i++){
        Array.push(arr[arr.length-i])
    }
    return Array;
}
var result = reverse(["a", "b", "c", "d", "e"]);
console.log(result); 


///////////////////* Fibonacci Array*/////////////////

function fibonacciArray(n) {
    var fibArr = [0, 1];
    for(i=2; i<n ;i++){
        fibArr[i]= fibArr[i-1]+fibArr[i-2]
    }
    return fibArr;
}
var result = fibonacciArray(10);
console.log(result); 


