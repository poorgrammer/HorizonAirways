
function showRoundtripForm(){
	
	if(document.getElementById("roundtripButton").checked){
		document.getElementById("roundtrip").style.display = "block";
	
		
	}
	else{
		document.getElementById("roundtrip").style.display = "none";

	}
	
	
}



window.onload = function(){

	document.getElementById("roundtripButton").onclick = showRoundtripForm;
	document.getElementById("onewayButton").onclick = showRoundtripForm;
	
	
};