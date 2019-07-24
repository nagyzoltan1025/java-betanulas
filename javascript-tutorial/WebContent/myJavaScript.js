/**
 * 
 */
'use strict';
document.writeln("<b>Bold Helloworld via an external js file</b>");
var obj = {};
obj.foo = 123;
document.writeln(obj.foo);
document.writeln('abc'.toUpperCase());
document.writeln(typeof null);
document.writeln(typeof undefined);
console.log(typeof null);

var i;								// One simple variable
var j = 0; 							// One var, one value
var p, q;							// Two variables
var greeting = "hello" + name;		// A complex initializer
var x = 2.34, y = Math.cos(0,75);	// Many variables
var x = 2, y = x*x;					// Second var uses the first var
var x = 2,							// Multiple variables
	f = function(x) {return x*x};	// each on it's own line
	y = f(x);
console.log(f(2));

var n = 2;
if (n == 1) {
	console.log("Execute code block #1");
} else if (n == 2) {
	console.log("Execute code block #2");
} else if (n == 3){
	console.log("Execute code block #3");
} else {
	console.log("Execute code block #4")
}

console.log("while")
var count = 0;
while (count < 10){
	console.log(count);
	count++;
}

console.log("do/while");
do {
	console.log(count);
	count--;
} while (count > 0)

console.log("for");
for (i = 0; i < 10; i = i + 2){
	console.log(i);
}
console.log("Enhanced for");
var primes = [2, 3,5, 7];
for (var prime in primes){
	console.log(prime);
}

console.log("break");
var i = 0;
while (i < 6) {
	if (i == 3) {
		break;
	}
	i++;
}
console.log(i)
// expected output: 3

console.log("continue");
var text = "";
for(var i = 0; i < 10; i++){
	if (i == 3) {
		continue
	}
	text = text + i;
}
console.log(text);
// expected output: 012456789

console.log("return");
function getRectArea(width, height){
	if (width > 0 && height > 0){
		return width * height;
	}
	return 0;
}

console.log(getRectArea(3,4));
// expected output: 12

console.log(getRectArea(-3, 4));
// expected output: 0

console.log("function expression");
var area = function(width, height){
	return width*height;
}
console.log(area(2,2));

console.log("Object constructor, Object prototype, Object initializer");
// Konstruktorral objektum létrehozása 
var myVehicle = new Object();
// propertyket hozzáadom:
myVehicle.speed = 0;
myVehicle.accelerate = function (){
	this.speed = this.speed + 10;
}
myVehicle.accelerate(); // hozzáadott függvény hívása
console.log("Vechile speed: " + myVehicle["speed"]); // hozzáférés objektum property értékhez
 
// Objektum létrehozása öröklődéssel
var myCar = Object.create(myVehicle);
myCar.type = "Ford";
myCar.year = "1960";
myCar.accelerate();
console.log(myCar["type"] + " speed: " + myCar.speed);

// Objektum inicializáló utasítás
var bicycle = {
		wheels: 2
};
delete bicycle.wheels; // objektum property törlése
console.log("Bicycle wheels: " + bicycle["wheels"]);