//All this function is doing is creating hexcodes for us
function getRandomColor() {
  var letters = '0123456789ABCDEF';
  var color = '#';
  for (var i = 0; i < 6; i++) {
    color += letters[Math.floor(Math.random() * 16)];
  }
  return color;
}

//grabbing the header and assigning the color value to the header property
function changeHeaderColor(){
  //var color = getRandomColor();
   var myHeader = document.querySelector("h1");
   myHeader.style.color = getRandomColor();
  //$("h2").css('color',color);
}

//performing color change action  over intervals of time (milliseconds)
setInterval("changeHeaderColor()", 500)