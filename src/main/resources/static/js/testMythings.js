
//destTarget is an element

function responseMyThings(xhttp, destTarget){
  if(xhttp.readyState ==4 && this.status ==200){
    destTarget.textContent = xhttp.response;

  }

}


function getMyThingsTestNODB(inputs, destTarget,responseAction){//destTarget = id of the target div
  var xmlRequest = new XMLHttpRequest();
  var url = "http://localhost:8080/mythings";
  xmlRequest.open("GET", url,true);
  xmlRequest.setRequestHeader("Content-Type", "application/json");
  xmlRequest.setRequestHeader("token", "MOCK");
  xmlRequest.onreadystatechange = responseAction(this, destTarget);


}

//var responsediv = document.getElementById("mythingsresult");
//responsediv.textContent = 'script is loaded';


//getMyThingsTestNODB("", document.getElementById("mythingsresult"),responseMyThings);
//alert("hi");
