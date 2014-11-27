
function showRoundtripForm(){
	
	if(document.getElementById("roundtripButton").checked){
		document.getElementById("roundtrip").style.display = "block";
		var fare = parseFloat(document.getElementById("firstFlightFare").value) + parseFloat(document.getElementById("secondFlightFare").value);
		document.getElementById("totalCost").innerHTML = "Total Cost: $" + fare + '.00';
		
	}
	else{
		document.getElementById("roundtrip").style.display = "none";
	var fare = parseFloat(document.getElementById("firstFlightFare").value);
	document.getElementById("totalCost").innerHTML = "Total Cost: $" + fare + '.00';
	
	}
	
	
}

function changeValue(){
	
	var firstFlightFare = parseFloat(document.getElementById("firstFlightFare").value);
	var secondFlightFare = (document.getElementById("roundtripButton").checked)?
			parseFloat(document.getElementById("secondFlightFare").value):+0.00;
		
	var totalcost = firstFlightFare + secondFlightFare;
	document.getElementById("totalCost").innerHTML = "Total Cost: $" + totalcost + '.00';
}

window.onload = function(){
	document.getElementById("totalCost").innerHTML = "Total Cost: $" + document.getElementById("firstFlightFare").value;
	document.getElementById("secondFlightFare").onchange = changeValue;
	document.getElementById("firstFlightFare").onchange = changeValue;
	document.getElementById("roundtripButton").onclick = showRoundtripForm;
	document.getElementById("onewayButton").onclick = showRoundtripForm;
	
	
};