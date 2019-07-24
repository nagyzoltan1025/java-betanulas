/**
 * 
 */
function getTitle() {
	return $("head title").text();
}

function addParagraph(){
	$("div").before("<p>Test</p>" );
}

function replaceElement(element, replacement){
	$(element).replaceWith(replacement);
}

var divs1 = $("div");
var divs2 = jQuery("div");
var divcolor = function(){
	$("#1").css("border", "3px solid red");
}



//$(document).ready(divcolor);
//console.log(getTitle());




//$(document).ready(addParagraph);

/*$(document).ready(function(){
	$("p").replaceWith("<p>Replaced</p>");
});*/

/*
$(document).ready(function(){
	$("#1").remove();
})
*/

$(document).ready(function() {
	$("li").each(function(index){
		console.log(index + ": " + $(this).text());
	});
})