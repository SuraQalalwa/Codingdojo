function pizzaOven(crustType, sauceType, cheeses, toppings) {
    var Pizza ={};
    Pizza.crustType=  crustType;
    Pizza.sauceType= sauceType;
    Pizza.cheeses=  cheeses; 
    Pizza.toppings= toppings; 
    return Pizza;
}

var Pizza1= pizzaOven("deep dish", "traditional", ["mozzarella"],["pepperoni", "sausage"]);
var Pizza2= pizzaOven("hand tossed", "marinara", ["mozzarella", "feta"],["mushrooms", "olives", "onions"]);
var Pizza3= pizzaOven("deep dish", "marinara", "feta",["mushrooms", "onions"]);
var Pizza4= pizzaOven("hand tossed", "marinara","feta","olives");
console.log("Pizza1:" + Pizza1);
console.log("Pizza2:" + Pizza2);
console.log("Pizza3:" + Pizza3);
console.log("Pizza4:" + Pizza4);


