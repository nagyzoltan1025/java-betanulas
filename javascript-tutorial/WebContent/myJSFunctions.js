/**
 * 
 */
'use strict';
// függvény deklaráció utasítással
function addition(a, b){
	return a + b;
}
console.log(addition(5,6));

// függvény deklaráció kifejezésként:
var substraction = function(a,b){
	return a-b;
}
console.log(substraction(11,5));




var add = function(a, b){
	return a+b;
}

var subs = function(a, b){
	return a-b;
}

var handleData = function(func){
	var x = 2;
	var y = 3;
	return func(x, y);
}

console.log(handleData(add));
console.log(handleData(subs));

funcDecl();


function funcDecl(){
	alert("function declared");
}
var funcExpr = function(){
	alert("function expression");
}
funcExpr();