## Part 1 - Non-intention-revealing variable names, unpronouncable names

These variables' intended purposes can be guessed by looking at their overall codes. However those could be more easily be represented by more carefully chosen names as demonstrated in cc_clean_code.md

In addition to that, it is better for the names to be pronouncable, unlike "cbtn" and "rmbtn" which not only requires more mental effort to remember and conceptualize compared to natural-language whole words, but may also cause difficulty in communication as they can be pronounced in different ways such as "see bee tee en", "cbutton", "kubten", "rumbten, "ar em bee tee en", etc.

```javascript
var overlay = document.createElement("div");
overlay.className = "overlay";

var cbtn = document.createElement("button");
cbtn.className = "togglebtn";
cbtn.innerHTML = "&#8230";
cbtn.addEventListener("click", function() {
    overlay.style.display = overlay.style.display == "none" ? "block" : "none";
})

var rmbtn = document.createElement("button");
rmbtn.className = "clearbtn";
rmbtn.innerHTML = "&times";
rmbtn.addEventListener("click", function() {
    overlay.style.display = "none";
    var possibleCanvases = overlay.getElementsByClassName("canvas");
    while (possibleCanvases.length > 0) {
        overlay.removeChild(possibleCanvases[0]);
    }
})

var canvas1 = document.createElement("canvas");
canvas1.classList.add("canvas","overlay-content");
overlay.appendChild(canvas1);
```