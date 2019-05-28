const imgDiv = document.getElementById("img");

function getImages() {
  const url =
    "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=2000&page=1&api_key=e6qeMVwVAobScq3QGBBCsWdk4haOxrTmcBfB3RPI";

  var allJsonText = "";
  var imageURLS = [];
  fetch(url)
    .then(function(response) {
      return response.json();
    })
    .then(function(imagesJson) {
      //get image URLS...
      allJsonText = imagesJson;

      //get URL of each image -
      console.log("getting all image URLs");
      for (var x = 0; x < allJsonText.photos.length; x++) {
        imageURLS[x] = '<img src="' + allJsonText.photos[x].img_src + '" />';
        console.log("img" + x);
      }
      return displayImages(imageURLS);
    });
}

//does not work
function displayImages(images) {
  // TODO make this display image(s) instead!
  console.log("inside displayImages");
  console.log(images.length);
  for (var y = 0; y < images.length; y++) {
    //console.log(y);
    console.log("displaying 1 img" + y);
    imgDiv.innerHTML = images[y];
  }

  /*
  Further work:
  Get each button press to display the next image, one at a time.. 
  */
}
